package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Transmission {

    //TODO: should this react on an RPM delta from the outside?
    Gear handleAcceleration(double pedalDepth);

    Gear handleDeacceleration();

    Gear handleManualUpshift();

    Gear handleManualDownshift();
}
