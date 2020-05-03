package com.dojczmaszin.gears;

public class RegularGear implements Gear {

    private int number;
    private final int maxGearNumber;


    public RegularGear(int number, int maxGearNumber) {
        this.number = number;
        this.maxGearNumber = maxGearNumber;
    }

    public Gear shiftUp() {
        if (isCurrentGearMax()) {
            return this;
        }
        return new RegularGear(this.number + 1, this.maxGearNumber);
    }

    @Override
    public Gear shiftDown() {
        if (isNextDownshiftNeutral()) {
            return new NeutralGear(this.maxGearNumber);
        }
        return new RegularGear(this.number - 1, this.maxGearNumber);
    }

    private boolean isNextDownshiftNeutral() {
        return this.number == 1;
    }

    private boolean isCurrentGearMax() {
        return this.number == this.maxGearNumber;
    }
}
