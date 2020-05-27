package com.dojczmaszin.gears;

public class ReverseGear implements Gear {

    @Override
    public Gear shiftUp() {
        return new NeutralGear();
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
}
