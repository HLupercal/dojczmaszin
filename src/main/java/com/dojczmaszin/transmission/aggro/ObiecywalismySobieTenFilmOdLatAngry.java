package com.dojczmaszin.transmission.aggro;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.LoudGearDecorator;

//second aggressive mode
public class ObiecywalismySobieTenFilmOdLatAngry implements AggroMode {
    @Override
    public double getDownshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/2;
    }

    @Override
    public double getUpshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/2;
    }

    @Override
    public double getDownshiftDeaccelRpmThreshold(double rpm) {
        return rpm + rpm/2;
    }

    @Override
    public Gear getAngryGear(Gear gear) {
        return new LoudGearDecorator(gear);
    }
}
