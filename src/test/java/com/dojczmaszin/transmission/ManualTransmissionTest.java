package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.MaxDriveGear;
import com.dojczmaszin.gears.NeutralGear;
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

    @Test
    void manual_upshift_from_max_drive_should_stay_on_max() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new MaxDriveGear(8, externalSystems);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        Gear result = transmission.handleManualUpshift();
        assertEquals(new MaxDriveGear(8, externalSystems), result);
    }

    @Test
    void manual_downshift_one_should_got_to_neutral() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(1, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        Gear result = transmission.handleManualDownshift();
        assertEquals(new NeutralGear(externalSystems, 8), result);
    }

    @Test
    void should_stay_in_gear_when_accelerating() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(1, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        //"lekko dotarty"
        externalSystems.setCurrentRpm(8000d);
        Gear result = transmission.handleAcceleration(1.0d);
        assertEquals(new DriveGear(1, externalSystems, 8), result);
    }

    @Test
    void should_stay_in_gear_when_deaccelerating() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear gear = new DriveGear(1, externalSystems, 8);
        Transmission transmission = getDefaultManualTransmissionInGear(gear);

        externalSystems.setCurrentRpm(500d);
        Gear result = transmission.handleDeacceleration();
        assertEquals(new DriveGear(1, externalSystems, 8), result);
    }

    private Transmission getDefaultManualTransmissionInGear(Gear gear) {
        Transmission transmission = new Manual(gear);
        return transmission;
    }
}
