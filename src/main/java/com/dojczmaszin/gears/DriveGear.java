package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.thirdparty.WrappedGearbox;
import com.dojczmaszin.transmission.Kickdown;

import java.util.Objects;

public class DriveGear implements Gear {
    private int number;
    private WrappedGearbox wrappedGearbox;
    private WrappedExternalSystems wrappedExternalSystems;

    public DriveGear(int number, WrappedGearbox wrappedGearbox, WrappedExternalSystems wrappedExternalSystems) {
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
        return new DriveGear(this.number++, this.wrappedGearbox, this.wrappedExternalSystems);
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return new NeutralGear();
        }
        return new DriveGear(this.number--, this.wrappedGearbox, this.wrappedExternalSystems);
    }

//    @Override
//    public Gear handleRpmDecrease(double rpmThreshold) {
//        if (wrappedExternalSystems.getCurrentRpm() < rpmThreshold) {
//            this.shiftDown();
//        }
//        return this;
//    }




    @Override
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold) {
        if (wrappedExternalSystems.getCurrentRpm() > shiftUpThreshold) {
            this.shiftUp();
        } else if (wrappedExternalSystems.getCurrentRpm() < shiftDownThreshold){
            this.shiftDown();
        }
        return this;
    }

    //inject how to do it
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold, Kickdown kickdown) {
        if (wrappedExternalSystems.getCurrentRpm() > shiftUpThreshold) {
            this.shiftUp();
        } else if (wrappedExternalSystems.getCurrentRpm() < shiftDownThreshold){
            this.shiftDown();
        }
        return this;
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
