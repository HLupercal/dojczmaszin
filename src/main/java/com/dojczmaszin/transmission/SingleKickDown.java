package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public class SingleKickDown implements Kickdown {

    private double pedalDepthThreshold;

    public SingleKickDown(double pedalDepthThreshold) {
        this.pedalDepthThreshold = pedalDepthThreshold;
    }

    @Override
    public Gear handle(double currentPedalDepth, Gear currentGear) {
        if (currentPedalDepth > pedalDepthThreshold) {
            return currentGear.shiftDown();
        }

        return currentGear;
    }

}
