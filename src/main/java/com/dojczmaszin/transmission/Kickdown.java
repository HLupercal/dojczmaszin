package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Kickdown {
    Gear handle(double currentPedalDepth, Gear currentGear);
}
