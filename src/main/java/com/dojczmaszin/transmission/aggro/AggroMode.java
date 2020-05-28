package com.dojczmaszin.transmission.aggro;

import com.dojczmaszin.gears.Gear;

public interface AggroMode {

    double getDownshiftAccelRpmThreshold(double rpm);

    double getUpshiftAccelRpmThreshold(double rpm);

    double getDownshiftDeaccelRpmThreshold(double rpm);

    Gear getAngryGear(Gear gear);
}
