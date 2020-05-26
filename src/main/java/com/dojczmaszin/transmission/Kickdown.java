package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Kickdown {
    void handleThreshold(double pedalDepthThreshold, Gear currentGear);
}
