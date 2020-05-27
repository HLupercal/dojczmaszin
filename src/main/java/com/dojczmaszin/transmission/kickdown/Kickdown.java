package com.dojczmaszin.transmission.kickdown;

import com.dojczmaszin.gears.Gear;

public interface Kickdown {
    Gear handle(double currentPedalDepth, Gear currentGear);
}
