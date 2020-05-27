package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public class Manual implements Transmission {

    private Gear currentGear;

    public Manual(Gear currentGear) {
        this.currentGear = currentGear;
    }

    @Override
    public Gear handleAcceleration(double pedalDepth, double rpmDelta) {
        return this.currentGear;
    }

    @Override
    public Gear handleDeacceleration(double rpmDelta) {
        return this.currentGear;
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
