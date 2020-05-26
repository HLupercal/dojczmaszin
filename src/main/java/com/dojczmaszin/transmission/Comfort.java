package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedGearbox;

public class Comfort implements Transmission {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenKickdownAcceleratingRpmThreshold;
    private Kickdown kickdown;
    private Gear currentGear;

    public Comfort() {

    }

    public Comfort(double shiftDownWhenAcceleratingRpmThreshold,
                   double shiftUpWhenAcceleratingRpmThreshold,
                   double shiftDownWhenKickdownAcceleratingRpmThreshold,
                   Kickdown kickdown,
                   Gear currentGear) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.shiftDownWhenKickdownAcceleratingRpmThreshold = shiftDownWhenKickdownAcceleratingRpmThreshold;
        this.kickdown = kickdown;
        this.currentGear = currentGear;
    }

    @Override
    public Gear handleRpmIncrease(double rpmDelta) {
        return null;
    }

    @Override
    public Gear handleRpmDecrease(double rpmDelta) {
        return null;
    }
}
