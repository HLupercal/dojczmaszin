package com.dojczmaszin.gears;

public class ReverseGear implements Gear {

    private int maxGearNumber;

    public ReverseGear(int maxGearNumber) {
        this.maxGearNumber = maxGearNumber;
    }

    @Override
    public Gear shiftUp() {
        return new NeutralGear(maxGearNumber);
    }

    @Override
    public Gear shiftDown() {
        return this;
    }
}
