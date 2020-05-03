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
}
