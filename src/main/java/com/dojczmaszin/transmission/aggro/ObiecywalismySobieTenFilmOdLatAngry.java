package com.dojczmaszin.transmission.aggro;

public class ObiecywalismySobieTenFilmOdLatAngry implements AggroMode {
    @Override
    public double getDownshiftAccelRpmThreshold(double rpm) {
        return rpm - rpm/2;
    }

    @Override
    public double getUpshiftAccelRpmThreshold(double rpm) {
        return rpm + rpm/2;
    }

    @Override
    public double getUpshiftDeaccelRpmThreshold(double rpm) {
        return rpm + rpm/2;
    }
}
