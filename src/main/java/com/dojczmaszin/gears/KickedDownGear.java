package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

import java.util.Objects;

public class KickedDownGear implements Gear {
    //TODO: make final
    private int number;
    private WrappedExternalSystems wrappedExternalSystems;
    private int maxNumber;

    public KickedDownGear(int number, WrappedExternalSystems wrappedExternalSystems, int maxNumber) {
        this.number = number;
        this.wrappedExternalSystems = wrappedExternalSystems;
        this.maxNumber = maxNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KickedDownGear that = (KickedDownGear) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Gear shiftUp() {
        //it's been kicked down so it must be able to go up
        return new DriveGear(this.number + 1, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear shiftDown() {
        //make sure this is correct
        return new DriveGear(this.number - 1, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        //special case - while still revving up directly after a kick down, change back to regular drive gear without doing anything
        return new DriveGear(this.number, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts) {
        //a kicked down gear cant handle another kickdown (although maybe it should?)
        return new DriveGear(this.number, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public int getNativeGearNumber() {
        return new DriveGear(this.number, this.wrappedExternalSystems, this.maxNumber).getNativeGearNumber();
    }

    @Override
    public int getNativeModeNumber() {
        return new DriveGear(this.number, this.wrappedExternalSystems, this.maxNumber).getNativeModeNumber();
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        //downreving doesnt work the same as reving up post kickdown, so just downshift regularly
        return new DriveGear(this.number, this.wrappedExternalSystems, this.maxNumber).handleRpmDecrease(shiftDownRpmThreshold);
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}
