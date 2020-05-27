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
        Gear neutralGear = new NeutralGear();
        Kickdown kickdown = new SingleKickDown(0.5d, 5000d);
        Transmission transmission = new Comfort(1000d,
                2500d,
                kickdown,
                neutralGear);

        getDefaultComfortTransmissionInGear(neutralGear);

        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        //when kickdown and revving
        Gear resultGear = transmission.handleAcceleration(0.6d, 3000d);

        //then should do nothing on neutral
        assertEquals(new NeutralGear(), resultGear);
    }

    @Test
    void testComfortDriveKickdown() {
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        Gear driveGear = new DriveGear(2, externalSystems);
        Transmission transmission = getDefaultComfortTransmissionInGear(driveGear);


        //when kickdown and above kickdown threshold
        Gear resultGear = transmission.handleAcceleration(0.6d, 3000d);

        //then should kick down one gear
        assertEquals(new DriveGear(1, externalSystems), resultGear);
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