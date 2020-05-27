package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

public class ReverseGear implements Gear {

    private int number = -1;
    private WrappedExternalSystems wrappedExternalSystems;
    private int maxNumber;

    @Override
    public Gear shiftUp() {
        return new NeutralGear(this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear shiftDown() {
        return this;
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        return this;
    }

    @Override
    public int getNativeGearNumber() {
        return -1;
    }

    @Override
    public int getNativeModeNumber() {
        return 3;
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
