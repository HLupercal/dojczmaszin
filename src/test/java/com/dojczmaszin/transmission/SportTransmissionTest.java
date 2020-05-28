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
    public void should_downshift_twice_on_hardkickdown() {

        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when kicking down hard with low enough rewolutjones per minute
        externalSystems.setCurrentRpm(4000d);
        Gear resultGear = sportTransmission.handleAcceleration(0.9d);
        //then should downshift twice
        assertEquals(new DriveGear(3, externalSystems, 8), resultGear);

    }

    @Test
    public void should_downshift_once_on_light_kickdown() {

        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when kicking down light with low enough rewolutjones per minute
        externalSystems.setCurrentRpm(5500d);
        Gear resultGear = sportTransmission.handleAcceleration(0.6d);
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);

    }

    @Test
    public void should_downshift_when_no_kickdown_and_below_downshift_revs_threshold() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when kicking down light with low enough rewolutjones per minute
        externalSystems.setCurrentRpm(1499d);
        Gear resultGear = sportTransmission.handleAcceleration(0.2d);
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }

    private Transmission getDefaultSportTransmissionInGear(Gear gear) {
        Kickdown kickdown = new DoubleKickdown(0.5d, 5000d,
                0.7d, 3000d);
        Transmission transmission = new Sport(1500d,
                2500d,
                kickdown,
                gear);
        return transmission;
    }

}
