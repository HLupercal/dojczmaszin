package com.dojczmaszin.transmission.aggro;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.LoudGearDecorator;
import com.dojczmaszin.transmission.Transmission;

//first aggressive mode
public class PoUjMiLasIrritated implements AggroMode {
    @Override
    public double getDownshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/3;
    }

    @Override
    public double getUpshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/3;
    }

    @Override
    public double getDownshiftDeaccelRpmThreshold(double rpm) {
        return rpm + rpm/3;
    }

    @Override
    public Gear getAngryGear(Gear gear) {
        return gear;
    }
}
