package com.dojczmaszin;

import com.dojczmaszin.thirdparty.WrappedGearbox;

public class GearboxDriver {

    WrappedGearbox gearbox;



    public void handleGas(int rpm) {
        gearbox.handleRpm(rpm)
    }

}
