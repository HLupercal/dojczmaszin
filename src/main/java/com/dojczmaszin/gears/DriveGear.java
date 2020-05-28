package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

import java.util.Objects;

public class DriveGear implements Gear {
    private int number;
    private WrappedExternalSystems wrappedExternalSystems;
    private int maxNumber;

    @Override
    public String toString() {
        return "DriveGear{" +
                "number=" + number +
                ", wrappedExternalSystems=" + wrappedExternalSystems +
                ", maxNumber=" + maxNumber +
                '}';
    }

    public DriveGear(int number, WrappedExternalSystems wrappedExternalSystems, int maxNumber) {
        if (number < 1 || number >= maxNumber) {
            throw new UnsupportedOperationException();
        }
        this.number = number;
        this.wrappedExternalSystems = wrappedExternalSystems;
        this.maxNumber = maxNumber;
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
        //TODO: maybe use a factory of sorts that would decide what to return?
        if (this.number + 1 == this.maxNumber) {
            return new MaxDriveGear(maxNumber, this.wrappedExternalSystems);
        }
        return new DriveGear(this.number + 1, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return new NeutralGear(this.wrappedExternalSystems, this.maxNumber);
        }
        return new DriveGear(this.number - 1, this.wrappedExternalSystems, this.maxNumber);
    }

    private Gear nonNeutralShiftDown(int numberOfDownshifts) {
        //never go below 1
        if (this.number - numberOfDownshifts < 1) {
            return new DriveGear(1, this.wrappedExternalSystems, this.maxNumber);
        }
        return new DriveGear(this.number - numberOfDownshifts, this.wrappedExternalSystems, this.maxNumber);
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() < shiftDownRpmThreshold) {
            return this.shiftDown();
        }
        return this;
    }


    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() > shiftUpThreshold) {
            return this.shiftUp();
        } else if (wrappedExternalSystems.getCurrentRpm() < shiftDownThreshold) {
            return this.shiftDown();
        }
        return this;
    }

    @Override
    public Gear handleKickDown(double kickDownThreshold, int howManyDownshifts) {
        Gear result = this;
        if (wrappedExternalSystems.getCurrentRpm() > kickDownThreshold) {
            //i guess kickingdown to neutral is dumb
            result = this.nonNeutralShiftDown(howManyDownshifts);
            return new KickedDownGear(result.getNumber(), this.wrappedExternalSystems, this.maxNumber);
        }
//        return new KickedDownGear(this.getNumber(), this.wrappedExternalSystems, this.maxNumber);
        return result;
    }


    @Override
    public int getNativeGearNumber() {
        return number;
    }

    @Override
    public int getNativeModeNumber() {
        return 1;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}
