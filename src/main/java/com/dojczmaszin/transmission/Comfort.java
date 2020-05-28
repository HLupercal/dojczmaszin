package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.transmission.aggro.AggressiveTransmission;
import com.dojczmaszin.transmission.aggro.AggroMode;
import com.dojczmaszin.transmission.kickdown.Kickdown;

public class Comfort implements Transmission, AggressiveTransmission {

    private double shiftDownWhenAcceleratingRpmThreshold;
    private double shiftUpWhenAcceleratingRpmThreshold;
    private double shiftDownWhenDeacceleratingRpmThreshold;
    private Kickdown kickdown;
    private Gear currentGear;

    public Comfort(double shiftDownWhenAcceleratingRpmThreshold,
                   double shiftUpWhenAcceleratingRpmThreshold,
                   double shiftDownWhenDeacceleratingRpmThreshold,
                   Kickdown kickdown,
                   Gear currentGear) {
        this.shiftDownWhenAcceleratingRpmThreshold = shiftDownWhenAcceleratingRpmThreshold;
        this.shiftUpWhenAcceleratingRpmThreshold = shiftUpWhenAcceleratingRpmThreshold;
        this.shiftDownWhenDeacceleratingRpmThreshold = shiftDownWhenDeacceleratingRpmThreshold;
        this.kickdown = kickdown;
        this.currentGear = currentGear;
    }

    @Override
    public Gear handleAcceleration(double pedalDepth) {
        Gear gear = kickdown.handle(pedalDepth, currentGear);
        return gear.handleRpmIncrease(this.shiftDownWhenAcceleratingRpmThreshold,
                this.shiftUpWhenAcceleratingRpmThreshold);
    }

    @Override
    public Gear handleDeacceleration() {
        return currentGear.handleRpmDecrease(this.shiftDownWhenDeacceleratingRpmThreshold);
    }

    @Override
    public Gear handleManualUpshift() {
        return this.currentGear.shiftUp();
    }

    @Override
    public Gear handleManualDownshift() {
        return this.currentGear.shiftDown();
    }

    @Override
    public void overrideDefaultTransmissionParams(AggroMode aggroMode) {
        //or maybe return a new transmission instance?
        this.shiftDownWhenAcceleratingRpmThreshold = aggroMode
                .getDownshiftAccelRpmThreshold(this.shiftDownWhenAcceleratingRpmThreshold);
        this.shiftUpWhenAcceleratingRpmThreshold = aggroMode
                .getUpshiftAccelRpmThreshold(this.shiftUpWhenAcceleratingRpmThreshold);
        this.shiftDownWhenDeacceleratingRpmThreshold = aggroMode
                .getDownshiftDeaccelRpmThreshold(this.shiftDownWhenDeacceleratingRpmThreshold);
    }
}
