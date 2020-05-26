package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedGearbox;

public class Comfort implements Transmission {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenKickdownAcceleratingRpmThreshold;
    private double kickdownPedalDepthThreshold;
    private WrappedGearbox wrappedGearbox;

    public Comfort() {

    }

    public Comfort(double shiftDownWhenAcceleratingRpmThreshold,
                   double shiftUpWhenAcceleratingRpmThreshold,
                   double shiftDownWhenKickdownAcceleratingRpmThreshold,
                   double kickdownPedalDepthThreshold,
                   WrappedGearbox wrappedGearbox) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.shiftDownWhenKickdownAcceleratingRpmThreshold = shiftDownWhenKickdownAcceleratingRpmThreshold;
        this.kickdownPedalDepthThreshold = kickdownPedalDepthThreshold;
        this.wrappedGearbox = wrappedGearbox;
    }

    @Override
    public Gear handleRpmIncrease() {
        return null;
    }

    @Override
    public Gear handleRpmDecrease() {
        return null;
    }
}
