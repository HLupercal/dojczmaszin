package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;

public class Drive implements TransmissionMode {
    private Gear currentGear;
    private int maxGears;

    public Drive(int currentGear, int maxGears) {
        this.currentGear = new DriveGear(currentGear);
        this.maxGears = maxGears;
    }

    @Override
    public TransmissionMode shiftUp() {
        return this;
    }

    @Override
    public TransmissionMode shiftDown() {
        if (isDownshiftToNeutral()) {
            return new Neutral();
        }

        return null;
    }

    private boolean isCurrentGearMax() {
        return this.currentGear.equals(new DriveGear(this.maxGears));
    }

    private boolean isDownshiftToNeutral() {
        return this.currentGear.equals(new DriveGear(1));
    }
}
