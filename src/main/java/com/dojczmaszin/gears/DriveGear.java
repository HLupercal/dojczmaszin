package com.dojczmaszin.gears;

import java.util.Objects;

public class DriveGear implements Gear {
    private int number;

    public DriveGear(int number) {
        this.number = number;
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
        return new DriveGear(this.number++);
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return new NeutralGear();
        }
        return new DriveGear(this.number--);
    }
}
