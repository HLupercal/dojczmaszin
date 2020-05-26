package com.dojczmaszin;

import com.dojczmaszin.thirdparty.WrappedGearbox;
import com.dojczmaszin.transmission.Comfort;
import com.dojczmaszin.transmission.Transmission;
import org.junit.jupiter.api.Test;

class GearboxDriverTest {

    @Test
    void handleRpmIncrease() {
        WrappedGearbox gearbox = new WrappedGearbox();
        Transmission transmission = new Comfort(1000d,
                2500d,
                4500d,
                0.5,
                gearbox);


    }
}