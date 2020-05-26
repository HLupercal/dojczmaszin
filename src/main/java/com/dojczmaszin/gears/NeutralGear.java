package com.dojczmaszin.gears;

public class NeutralGear implements Gear {

    @Override
    public Gear shiftUp() {
        return new DriveGear(1);
    }

    @Override
    public Gear shiftDown() {
        return new ReverseGear();
    }
}
