package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Transmission {
    Gear handleAcceleration(double pedalDepth, double rpmDelta);

    Gear handleDeacceleration(double rpmDelta);
}
