package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.thirdparty.WrappedGearbox;

public class KickedDownGear implements Gear {
    //TODO: make final
    private int number;
    private WrappedGearbox wrappedGearbox;
    private WrappedExternalSystems wrappedExternalSystems;

    public KickedDownGear(int number, WrappedGearbox wrappedGearbox, WrappedExternalSystems wrappedExternalSystems) {
        this.number = number;
        this.wrappedGearbox = wrappedGearbox;
        this.wrappedExternalSystems = wrappedExternalSystems;
    }

    @Override
    public Gear shiftUp() {
        //it's been kicked down so it must be able to go up
        return new DriveGear(this.number++, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public Gear shiftDown() {
        //make sure this is correct
        return new DriveGear(this.number--, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        //special case - while stil reving up directly after a kick down, change back to regular drive gear without doing anything
        return new DriveGear(this.number, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts) {
        //a kicked down gear cant handle another kickdown (although maybe it should?)
        return new DriveGear(this.number, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public int getNativeGearNumber() {
        return new DriveGear(this.number, this.wrappedGearbox, this.wrappedExternalSystems).getNativeGearNumber();
    }

    @Override
    public int getNativeModeNumber() {
        return new DriveGear(this.number, this.wrappedGearbox, this.wrappedExternalSystems).getNativeModeNumber();
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        //downreving doesnt work the same as reving up post kickdown, so just downshift regularly
        return new DriveGear(this.number, this.wrappedGearbox, this.wrappedExternalSystems).handleRpmDecrease(shiftDownRpmThreshold);
    }
}