package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.NeutralGear;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.transmission.kickdown.Kickdown;
import com.dojczmaszin.transmission.kickdown.SingleKickDown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComfortTransmissionTest {

    @Test
    void testComfortNeutralKickdown() {
        //given

        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear neutralGear = new NeutralGear(externalSystems, 8);
        Kickdown kickdown = new SingleKickDown(0.5d, 5000d);
        Transmission transmission = new Comfort(1000d,
                2500d,
                kickdown,
                neutralGear);

        getDefaultComfortTransmissionInGear(neutralGear);

        //when kickdown and revving
        externalSystems.increaseRpm(2000d);
        Gear resultGear = transmission.handleAcceleration(0.6d);

        //then should do nothing on neutral
        assertEquals(new NeutralGear(externalSystems, 8), resultGear);
    }

    @Test
    void testComfortDriveKickdown() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear driveGear = new DriveGear(2, externalSystems, 8);
        Transmission transmission = getDefaultComfortTransmissionInGear(driveGear);


        //when kickdown and above kickdown threshold
        externalSystems.increaseRpm(2000d);
        Gear resultGear = transmission.handleAcceleration(0.6d);

        //then should kick down one gear
        assertEquals(new DriveGear(1, externalSystems, 8), resultGear);
    }

    private Transmission getDefaultComfortTransmissionInGear(Gear gear) {
        Kickdown kickdown = new SingleKickDown(0.5d, 5000d);
        Transmission transmission = new Comfort(1000d,
                2500d,
                kickdown,
                gear);
        return transmission;
    }
}