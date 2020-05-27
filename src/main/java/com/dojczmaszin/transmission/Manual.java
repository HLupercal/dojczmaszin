package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public class Manual implements Transmission {

    private Gear currentGear;

    public Manual(Gear currentGear) {
        this.currentGear = currentGear;
    }

    @Override
    public Gear handleAcceleration(double pedalDepth) {
        return this.currentGear;
    }

    @Override
    public Gear handleDeacceleration() {
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
