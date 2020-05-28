package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Transmission {

    Gear handleAcceleration(double pedalDepth);

    Gear handleDeacceleration();

    Gear handleManualUpshift();

    Gear handleManualDownshift();
}
