package com.dojczmaszin;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.NeutralGear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.transmission.Comfort;
import com.dojczmaszin.transmission.Transmission;
import org.junit.jupiter.api.Test;

class GearboxDriverTest {

    @Test
    void handleRpmIncrease() {
        Gear neutralGear = new NeutralGear();
        Transmission transmission = new Comfort(1000d,
                2500d,
                4500d,
                0.5,
                neutralGear);

        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        transmission.handleRpmIncrease(1500d);
    }
}