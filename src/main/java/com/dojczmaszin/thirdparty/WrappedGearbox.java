package com.dojczmaszin.thirdparty;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.NeutralGear;
import com.dojczmaszin.thirdparty.raw.Gearbox;

public class WrappedGearbox {

    private Gearbox gearbox;
    private static final int DEFAULT_MAX_GEAR = 8;
    private Gear currentGear;

    public WrappedGearbox() {
        this(DEFAULT_MAX_GEAR, new NeutralGear());
    }

    private WrappedGearbox(int maxGear, Gear currentGear) {
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(maxGear);
        this.currentGear = currentGear;
    }

    public int getMaxGear() {
        return this.gearbox.getMaxDrive();
    }

    private Gear getCurrentGear() {
        return this.currentGear;
    }
}
