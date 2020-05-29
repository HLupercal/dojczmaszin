package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.LoudGearDecorator;
import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.transmission.aggro.AggroMode;
import com.dojczmaszin.transmission.aggro.ObiecywalismySobieTenFilmOdLatAngry;
import com.dojczmaszin.transmission.aggro.PoUjMiLasIrritated;
import com.dojczmaszin.transmission.kickdown.DoubleKickdown;
import com.dojczmaszin.transmission.kickdown.Kickdown;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void should_downshift_when_deaccelerating_below_rpm_threshold() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when below rpm
        externalSystems.setCurrentRpm(2999d);
        Gear resultGear = sportTransmission.handleDeacceleration();
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }

    @Test
    public void should_downshift_when_deaccelerating_above_rpm_threshold() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when above rpm
        externalSystems.setCurrentRpm(3001d);
        Gear resultGear = sportTransmission.handleDeacceleration();
        //then should downshift once
        assertEquals(new DriveGear(5, externalSystems, 8), resultGear);
    }

    @Test
    public void should_manually_upshift() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        Gear resultGear = sportTransmission.handleManualUpshift();
        //then should downshift once
        assertEquals(new DriveGear(6, externalSystems, 8), resultGear);
    }


    @Test
    public void should_manually_downshift() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Transmission sportTransmission = getDefaultSportTransmissionInGear(gear);

        Gear resultGear = sportTransmission.handleManualDownshift();
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }


    @Test
    public void should_not_downshift_when_rpm_in_range() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Sport sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when above rpm
        AggroMode aggroMode = new PoUjMiLasIrritated();
        sportTransmission.overrideTransmissionParams(aggroMode);
        externalSystems.setCurrentRpm(1800d);
        Gear resultGear = sportTransmission.handleAcceleration(0.4d);
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }

    @Test
    public void should_downshift_sooner_when_accelerating_on_first_aggressive_mode_override() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Sport sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when above rpm
        AggroMode aggroMode = new PoUjMiLasIrritated();
        sportTransmission.overrideTransmissionParams(aggroMode);
        externalSystems.setCurrentRpm(1800d);
        Gear resultGear = sportTransmission.handleAcceleration(0.4d);
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }

    @Test
    public void should_upshift_later_when_accelerating_on_first_aggressive_mode_override() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Sport sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when above rpm
        AggroMode aggroMode = new PoUjMiLasIrritated();
        sportTransmission.overrideTransmissionParams(aggroMode);
        externalSystems.setCurrentRpm(3000d);
        Gear resultGear = sportTransmission.handleAcceleration(0.4d);
        //then should downshift once
        assertEquals(new DriveGear(5, externalSystems, 8), resultGear);
    }

    @Test
    public void should_downshift_faster_when_deaccelerating_on_first_aggressive_mode_override() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Sport sportTransmission = getDefaultSportTransmissionInGear(gear);

        //when above rpm
        AggroMode aggroMode = new PoUjMiLasIrritated();
        sportTransmission.overrideTransmissionParams(aggroMode);
        externalSystems.setCurrentRpm(3999d);
        Gear resultGear = sportTransmission.handleDeacceleration();
        //then should downshift once
        assertEquals(new DriveGear(4, externalSystems, 8), resultGear);
    }

    @Test
    public void should_be_obnoxiously_loud_when_downshifting_on_second_aggro_mode() {
        //given
        WrappedExternalSystems externalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(5, externalSystems, 8);
        Sport sportTransmission = getDefaultSportTransmissionInGear(gear);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //when above rpm
        AggroMode aggroMode = new ObiecywalismySobieTenFilmOdLatAngry();
        sportTransmission.overrideTransmissionParams(aggroMode);
        externalSystems.setCurrentRpm(1800d);
        Gear resultGear = sportTransmission.handleAcceleration(0.4d);
        //then should downshift once
        assertEquals(new LoudGearDecorator(new DriveGear(4, externalSystems, 8)), resultGear);
        //and be kinda loud
        assertEquals("I'm way louder than hetfield before he got old\n", outContent.toString());

    }

    private Sport getDefaultSportTransmissionInGear(Gear gear) {
        Kickdown kickdown = new DoubleKickdown(0.5d, 5000d,
                0.7d, 3000d);
        Sport transmission = new Sport(1500d,
                2500d,
                3000d,
                kickdown,
                gear);
        return transmission;
    }

}
