package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public class SingleKickDown implements Kickdown {

    @Override
    public Gear handleThreshold(double pedalDepthThreshold, Gear currentGear) {
         currentGear.shiftDown();
    }
}
