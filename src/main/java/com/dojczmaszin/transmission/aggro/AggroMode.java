package com.dojczmaszin.transmission.aggro;

public interface AggroMode {

    double getDownshiftAccelRpmThreshold(double rpm);

    double getUpshiftAccelRpmThreshold(double rpm);

    double getUpshiftDeaccelRpmThreshold(double rpm);
}
