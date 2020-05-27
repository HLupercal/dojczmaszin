package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.transmission.kickdown.DoubleKickdown;
import com.dojczmaszin.transmission.kickdown.Kickdown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SportTransmissionTest {


    @Test
    public void shouldDownshiftTwiceOnHardkickDown() {

        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when kicking down hard with low enough rewolutjones per minute
        Gear resultGear = sportTransmission.handleAcceleration(0.9d, 4000d);
        //then should downshift twice
        assertEquals(new DriveGear(3, externalSystems), resultGear);

    }


    public void shouldDownshiftOnceOnLightKickDown() {

        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when kicking down light with low enough rewolutjones per minute
        Gear resultGear = sportTransmission.handleAcceleration(0.6d, 5500d);
        //then should downshift once
        assertEquals(new DriveGear(2, externalSystems), resultGear);

    }

    private Transmission getDefaultSportTransmissionInGear(Gear gear) {
        Kickdown kickdown = new DoubleKickdown(0.5d, 5000d,
                0.7d, 3000d);
        Transmission transmission = new Sport(1000d,
                2500d,
                kickdown,
                gear);
        return transmission;
    }

}
