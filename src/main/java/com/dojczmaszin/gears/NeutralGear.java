package com.dojczmaszin.gears;

public class NeutralGear implements Gear {

    private int maxGearNumber;

    public NeutralGear(int maxGearNumber) {
        this.maxGearNumber = maxGearNumber;
    }

    @Override
    public Gear shiftUp() {
        return new RegularGear(1, this.maxGearNumber);
    }

    @Override
    public Gear shiftDown() {
        return new ReverseGear();
    }
}
