package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedGearbox;

public class Comfort implements Transmission {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenKickdownAcceleratingRpmThreshold;
    private double kickdownPedalDepthThreshold;
    private Gear currentGear;

    public Comfort() {

    }

    public Comfort(double shiftDownWhenAcceleratingRpmThreshold,
                   double shiftUpWhenAcceleratingRpmThreshold,
                   double shiftDownWhenKickdownAcceleratingRpmThreshold,
                   double kickdownPedalDepthThreshold,
                   Gear currentGear) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.shiftDownWhenKickdownAcceleratingRpmThreshold = shiftDownWhenKickdownAcceleratingRpmThreshold;
        this.kickdownPedalDepthThreshold = kickdownPedalDepthThreshold;
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
