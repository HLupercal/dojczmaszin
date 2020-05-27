package com.dojczmaszin.thirdparty;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.NeutralGear;

public class WrappedGearbox {

    private Gearbox gearbox;
    private static final int DEFAULT_MAX_GEAR = 8;
    private Gear currentGear;

    //assumed defaults
    public WrappedGearbox() {
        this(DEFAULT_MAX_GEAR, new NeutralGear());
    }

    private WrappedGearbox(int maxGear, Gear currentGear) {
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(maxGear);
        this.currentGear = currentGear;
    }

    public Gear setCurrentGear(Gear currentGear) {
        this.currentGear = currentGear;
        gearbox.setCurrentGear(currentGear.getNativeGearNumber());
        //move this to dedicated resolving function
        gearbox.setGearBoxCurrentParams(new Object[]{
                currentGear.getNativeGearNumber(),
                currentGear.getNativeModeNumber()});
        //i assume rpm changes automatically when a gear is shifted
        return currentGear;
    }

    public int getMaxGear() {
        return this.gearbox.getMaxDrive();
    }

    public Gear getCurrentGear() {
        return this.currentGear;
    }
}
