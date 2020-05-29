package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.transmission.aggro.AggroMode;

public interface Transmission {

    Gear handleAcceleration(double pedalDepth);

    Gear handleDeacceleration();

    Gear handleManualUpshift();

    Gear handleManualDownshift();

    void overrideTransmissionParams(AggroMode aggroMode);
}
