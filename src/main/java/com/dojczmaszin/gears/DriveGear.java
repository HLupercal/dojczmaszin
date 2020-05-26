package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedGearbox;

import java.util.Objects;

public class DriveGear implements Gear {
    private int number;
    private WrappedGearbox wrappedGearbox;

    public DriveGear(int number, WrappedGearbox wrappedGearbox) {
        this.number = number;
        this.wrappedGearbox = wrappedGearbox;
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
        return new DriveGear(this.number++, this.wrappedGearbox);
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return new NeutralGear();
        }
        return new DriveGear(this.number--, this.wrappedGearbox);
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
