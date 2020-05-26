package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public class Comfort implements Transmission, Kickdownable {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenDeaccelerating;
    private Kickdown kickdown;
    private Gear currentGear;

    public Comfort(double shiftDownWhenAcceleratingRpmThreshold,
                   double shiftUpWhenAcceleratingRpmThreshold,
                   Kickdown kickdown,
                   Gear currentGear) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.kickdown = kickdown;
        this.currentGear = currentGear;
    }

    @Override
    public Gear handleAcceleration(double pedalDepth, double rpmDelta) {
        Gear gear = kickdown.handle(pedalDepth, currentGear);
        return currentGear.handleRpmIncrease(this.shiftDownWhenAcceleratingRpmThreshold,
                this.shiftUpWhenAcceleratingRpmThreshold);
    }
    
    @Override
    public Gear handleDeacceleration(double rpmDelta) {
        return currentGear.handleRpmDecrease(this.shiftDownWhenDeaccelerating);
    }

    @Override
    public Gear handleKickdown(double pedalDepth) {
        return kickdown.handle(pedalDepth, currentGear);
    }
}
