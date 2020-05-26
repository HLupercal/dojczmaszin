package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.thirdparty.WrappedGearbox;
import com.dojczmaszin.transmission.Kickdown;

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
        //special case - directly after kick down, change back to regular drive gear
        return new DriveGear(this.number ,this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public int getNativeGearNumber() {
        return new DriveGear(this.number ,this.wrappedGearbox, this.wrappedExternalSystems).getNativeGearNumber();
    }

    @Override
    public int getNativeModeNumber() {
        return new DriveGear(this.number ,this.wrappedGearbox, this.wrappedExternalSystems).getNativeModeNumber();
    }
}
