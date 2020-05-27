package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.MaxDriveGear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualTransmissionTest {


    @Test
    public void manual_upshift_from_any_non_max_drive_gear_should_go_up_by_one() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(3, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        Gear result = transmission.handleManualUpshift();
        assertEquals(new DriveGear(4, externalSystems, 8), result);
    }


    @Test
    public void manual_upshift_from_one_less_than_max_drive_should_shift_to_max() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(7, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        Gear result = transmission.handleManualUpshift();
        assertEquals(new MaxDriveGear(8, externalSystems), result);
    }

    private Transmission getDefaultManualTransmissionInGear(Gear gear) {
        Transmission transmission = new Manual(gear);
        return transmission;
    }
}
