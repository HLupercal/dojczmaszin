package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

import java.util.Objects;

public class MaxDriveGear implements Gear {
    private WrappedExternalSystems wrappedExternalSystems;
    private int number;

    public MaxDriveGear(int maxGear, WrappedExternalSystems wrappedExternalSystems) {
        this.number = maxGear;
        this.wrappedExternalSystems = wrappedExternalSystems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxDriveGear that = (MaxDriveGear) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Gear shiftUp() {
        return this;
    }

    @Override
    public Gear shiftDown() {
        return new DriveGear(this.number--, this.wrappedExternalSystems);
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold) {
        return this;
    }

    @Override
    public int getNativeGearNumber() {
        return 8;
    }

    @Override
    public int getNativeModeNumber() {
        return 1;
    }

    @Override
    public Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts) {
        return this;
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() < shiftDownRpmThreshold) {
            this.shiftDown();
        }
        return this;
    }

    @Override
    public int getNumber() {
        return this.number;
    }


}
