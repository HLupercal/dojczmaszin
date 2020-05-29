package com.dojczmaszin;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedGearbox;
import com.dojczmaszin.transmission.Transmission;
import com.dojczmaszin.transmission.aggro.AggroMode;

public class GearboxDriver {

    private Transmission transmission;
    private WrappedGearbox wrappedGearbox;

    public GearboxDriver(Transmission transmission, WrappedGearbox wrappedGearbox) {
        this.transmission = transmission;
        this.wrappedGearbox = wrappedGearbox;
    }

    public void handleAcceleration(double pedalDepth) {
        Gear gear = transmission.handleAcceleration(pedalDepth);
        wrappedGearbox.setCurrentGear(gear);
    }

    public void handleDeacceleration() {
        Gear gear = transmission.handleDeacceleration();
        wrappedGearbox.setCurrentGear(gear);
    }

    public void handleManualUpshift() {
        Gear gear = transmission.handleManualUpshift();
        wrappedGearbox.setCurrentGear(gear);
    }

    public void handleManualDownshift() {
        Gear gear = transmission.handleManualDownshift();
        wrappedGearbox.setCurrentGear(gear);
    }

    public void switchTransmissionMode(Transmission mode) {
        this.transmission = transmission;
    }

    public void switchAggressiveMode(AggroMode mode) {
        this.transmission.overrideTransmissionParams(mode);
    }

}
