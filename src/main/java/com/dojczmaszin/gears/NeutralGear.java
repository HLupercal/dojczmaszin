package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

public class NeutralGear implements Gear {

    private WrappedExternalSystems wrappedExternalSystems;

    @Override
    public Gear shiftUp() {
        return new DriveGear(1, wrappedExternalSystems);
    }

    @Override
    public Gear shiftDown() {
        return new ReverseGear();
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
        return 0;
    }
}
