package com.dojczmaszin;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.NeutralGear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.transmission.Comfort;
import com.dojczmaszin.transmission.Kickdown;
import com.dojczmaszin.transmission.SingleKickDown;
import com.dojczmaszin.transmission.Transmission;
import org.junit.jupiter.api.Test;

class GearboxDriverTest {

    @Test
    void handleComfortRpmIncrease() {
        Gear neutralGear = new NeutralGear();
        Kickdown kickdown = new SingleKickDown(0.5d);
        Transmission transmission = new Comfort(1000d,
                2500d,
                4500d,
                kickdown,
                neutralGear);

        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        transmission.handleRpmIncrease(1500d);
    }
}