package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.thirdparty.WrappedGearbox;

import java.util.Objects;

public class DriveGear implements Gear {
    private int number;
    private WrappedGearbox wrappedGearbox;
    private WrappedExternalSystems wrappedExternalSystems;

    public DriveGear(int number, WrappedGearbox wrappedGearbox, WrappedExternalSystems wrappedExternalSystems) {
        if (number < 1) {
            throw new UnsupportedOperationException();
        }
        this.number = number;
        this.wrappedGearbox = wrappedGearbox;
        this.wrappedExternalSystems = wrappedExternalSystems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriveGear driveGear = (DriveGear) o;
        return number == driveGear.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Gear shiftUp() {
        return wrappedGearbox.setCurrentGear(new DriveGear(this.number++, this.wrappedGearbox, this.wrappedExternalSystems));
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return wrappedGearbox.setCurrentGear(new NeutralGear());
        }
        return wrappedGearbox.setCurrentGear(new DriveGear(this.number--, this.wrappedGearbox, this.wrappedExternalSystems));
    }

    private Gear nonNeutralShiftDown() {
        //never go beyond 1
        if (this.number == 1) {
            return this;
        }
        return new DriveGear(this.number--, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() < shiftDownRpmThreshold) {
            this.shiftDown();
        }
        return this;
    }


    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() > shiftUpThreshold) {
            return wrappedGearbox.setCurrentGear(this.shiftUp());
        } else if (wrappedExternalSystems.getCurrentRpm() < shiftDownThreshold) {
            return wrappedGearbox.setCurrentGear(this.shiftDown());
        }
        //already set
        return this;
    }

    @Override
    public Gear handleKickDown(double kickDownThreshold, int howManyDownshifts) {
        Gear gear = this;
        if (wrappedExternalSystems.getCurrentRpm() < kickDownThreshold) {
            for (int i = 0; i < howManyDownshifts; i++) {
                gear = this.nonNeutralShiftDown();
            }
        }
        return wrappedGearbox.setCurrentGear(gear);
    }


    @Override
    public int getNativeGearNumber() {
        return number;
    }

    @Override
    public int getNativeModeNumber() {
        return 1;
    }
}
