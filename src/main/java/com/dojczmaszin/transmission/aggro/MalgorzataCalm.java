package com.dojczmaszin.transmission.aggro;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.LoudGearDecorator;

public class MalgorzataCalm implements AggroMode {
    @Override
    public double getDownshiftAccelRpmThreshold(double rpm) {
        return rpm;
    }

    @Override
    public double getUpshiftAccelRpmThreshold(double rpm) {
        return rpm;
    }

    @Override
    public double getDownshiftDeaccelRpmThreshold(double rpm) {
        return rpm ;
    }

    @Override
    public Gear getAngryGear(Gear gear) {
        return gear;
    }
}
