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
    public int getNativeGearNumber() {
        return -1;
    }

    @Override
    public int getNativeModeNumber() {
        return 3;
    }
}
