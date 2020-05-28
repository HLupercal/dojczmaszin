package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

import java.util.Objects;

public class NeutralGear implements Gear {

    private int number = 0;
    private WrappedExternalSystems wrappedExternalSystems;
    private int maxNumber;

    public NeutralGear(WrappedExternalSystems wrappedExternalSystems, int maxNumber) {
        this.wrappedExternalSystems = wrappedExternalSystems;
        this.maxNumber = maxNumber;
    }


    @Override
    public String toString() {
        return "NeutralGear{" +
                "number=" + number +
                ", wrappedExternalSystems=" + wrappedExternalSystems +
                ", maxNumber=" + maxNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NeutralGear that = (NeutralGear) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Gear shiftUp() {
        return new DriveGear(1, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear shiftDown() {
        //I think this shouldn't result in Reverse
        return this;
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold) {
        return this;
    }

    @Override
    public int getNativeGearNumber() {
        return 0;
    }

    @Override
    public int getNativeModeNumber() {
        return 4;
    }

    @Override
    public Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts) {
        return this;
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        return this;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}
