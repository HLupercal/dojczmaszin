package com.dojczmaszin.transmission.aggro;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.transmission.Transmission;

public class PoUjMiLasIrritated implements AggroMode {
    @Override
    public double getDownshiftAccelRpmThreshold(double rpm) {
        return rpm - rpm/3;
    }

    @Override
    public double getUpshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/3;
    }

    @Override
    public double getUpshiftDeaccelRpmThreshold(double rpm) {
        return rpm + rpm/3;
    }
}
