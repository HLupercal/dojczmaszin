package com.dojczmaszin.transmission.aggro;

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
}
