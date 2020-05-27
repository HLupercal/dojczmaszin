package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualTransmissionTest {


    @Test
    public void testSingleManualUpshift() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(3, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        Gear result = transmission.handleManualUpshift();
        assertEquals(new DriveGear(4, externalSystems, 8), result);
    }


    private Transmission getDefaultManualTransmissionInGear(Gear gear) {
        Transmission transmission = new Manual(gear);
        return transmission;
    }
}
