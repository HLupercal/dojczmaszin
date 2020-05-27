package com.dojczmaszin.transmission.kickdown;

import com.dojczmaszin.gears.Gear;

public class DoubleKickdown implements Kickdown {

    private double lightKickDownPedalDepthThreshold;
    private double lightkickDownRpmThreshold;
    private double hardKickDownPedalDepthThreshold;
    private double hardkickDownRpmThreshold;

    public DoubleKickdown(double lightKickDownPedalDepth, double lightkickDownRpmThreshold, double hardKickDownPedalDepth, double hardkickDownRpmThreshold) {
        this.lightKickDownPedalDepthThreshold = lightKickDownPedalDepth;
        this.lightkickDownRpmThreshold = lightkickDownRpmThreshold;
        this.hardKickDownPedalDepthThreshold = hardKickDownPedalDepth;
        this.hardkickDownRpmThreshold = hardkickDownRpmThreshold;
    }

    @Override
    public Gear handle(double currentPedalDepth, Gear currentGear) {
        //deep enough for double downshift
        if (currentPedalDepth > hardKickDownPedalDepthThreshold) {
            return currentGear.handleKickDown(this.hardkickDownRpmThreshold, 2);
        //deep enough only for single downshift
        } else if (currentPedalDepth > lightKickDownPedalDepthThreshold) {
            return currentGear.handleKickDown(this.lightkickDownRpmThreshold, 1);
        }
        return currentGear;
    }
}
