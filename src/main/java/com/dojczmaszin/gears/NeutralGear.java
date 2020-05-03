package com.dojczmaszin.gears;

public class NeutralGear implements Gear {

    private int maxGearNumber;

    public NeutralGear(int maxGearNumber) {
        this.maxGearNumber = maxGearNumber;
    }

    @Override
    public Gear shiftUp() {
        return new DriveGear(1, this.maxGearNumber);
    }

    @Override
    public Gear shiftDown() {
        return new ReverseGear(this.maxGearNumber);
    }
}
