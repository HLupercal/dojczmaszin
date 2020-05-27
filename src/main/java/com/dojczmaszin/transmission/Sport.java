package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.transmission.kickdown.Kickdown;

public class Sport implements Transmission {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenDeacceleratingRpmThreshold;
    private Kickdown kickdown;
    private Gear currentGear;

    public Sport(double shiftDownWhenAcceleratingRpmThreshold,
                 double shiftUpWhenAcceleratingRpmThreshold,
                 Kickdown kickdown,
                 Gear currentGear) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.shiftDownWhenDeacceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.kickdown = kickdown;
        this.currentGear = currentGear;

    }

    @Override
    public Gear handleAcceleration(double pedalDepth, double rpmDelta) {
        Gear gear = kickdown.handle(pedalDepth, currentGear);
        return gear.handleRpmIncrease(this.shiftDownWhenAcceleratingRpmThreshold,
                this.shiftUpWhenAcceleratingRpmThreshold);
    }

    @Override
    public Gear handleDeacceleration(double rpmDelta) {
        return currentGear.handleRpmDecrease(this.shiftDownWhenDeacceleratingRpmThreshold);
    }

    @Override
    public Gear handleManualUpshift() {
        return currentGear.shiftUp();
    }

    @Override
    public Gear handleManualDownshift() {
        return currentGear.shiftDown();
    }
}
