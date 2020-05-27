package com.dojczmaszin.transmission.kickdown;

import com.dojczmaszin.gears.Gear;

public class SingleKickDown implements Kickdown {

    private double pedalDepthThreshold;
    private double kickDownRpmThreshold;

    public SingleKickDown(double pedalDepthThreshold, double kickdownRpmThreshold) {
        this.pedalDepthThreshold = pedalDepthThreshold;
        this.kickDownRpmThreshold = kickdownRpmThreshold;
    }

    @Override
    public Gear handle(double currentPedalDepth, Gear currentGear) {
        if (currentPedalDepth > pedalDepthThreshold) {
            return currentGear.handleKickDown(this.kickDownRpmThreshold, 1);
        }

        return currentGear;
    }

}
