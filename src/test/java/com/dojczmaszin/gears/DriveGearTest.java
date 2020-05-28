package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DriveGearTest {


    @Test
    void down_shift_from_one_should_result_in_neutral() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(1, wrappedExternalSystems, 8);
        Gear result = gear.shiftDown();
        assertEquals(new NeutralGear(wrappedExternalSystems, 8), result);
    }

    @Test
    void down_shift_from_not_one_should_result_in_one_lower_drive_gear() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(4, wrappedExternalSystems, 8);
        Gear result = gear.shiftDown();
        assertEquals(new DriveGear(3, wrappedExternalSystems, 8), result);
    }

    @Test
    void non_neutral_down_shift_from_one_should_result_in_one() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(1, wrappedExternalSystems, 8);
        Gear result = gear.shiftDown();
        assertEquals(new NeutralGear(wrappedExternalSystems, 8), result);
    }

    @Test
    void up_shift_from_one_or_above_should_result_in_one_higher_drive_gear() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(4, wrappedExternalSystems, 8);
        Gear result = gear.shiftUp();
        assertEquals(new DriveGear(5, wrappedExternalSystems, 8), result);
    }

    @Test
    void up_shift_from_max_gear_minus_one_should_result_in_max_gear() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.shiftUp();
        assertEquals(new MaxDriveGear(8, wrappedExternalSystems), result);
    }


    @Test
    void should_downshift_when_rpm_below_threshold() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(999d);
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleRpmDecrease(1000d);
        assertEquals(new DriveGear(6, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_upshift_when_rpm_above_threshold() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        DriveGear gear = new DriveGear(6, wrappedExternalSystems, 8);
        Gear result = gear.handleRpmIncrease(500d, 1000d);
        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_stay_in_gear_when_rpm_increased_between_thresholds() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(2000d);
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleRpmIncrease(1000d, 5000d);

        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_stay_in_gear_when_rpm_decreased_between_thresholds() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(2000d);
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleRpmDecrease(1000d);

        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_kickdown_when_above_rpm_threshold() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleKickDown(1000d, 1);

        assertEquals(new KickedDownGear(6, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_kickdown_when_above_rpm_threshold_but_in_first_gear() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        DriveGear gear = new DriveGear(1, wrappedExternalSystems, 8);
        Gear result = gear.handleKickDown(1000d, 1);

        assertEquals(new KickedDownGear(1, wrappedExternalSystems, 8), result);
    }

    @Test
    void should_not_kickdown_when_below_rpm_threshold() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(999d);
        DriveGear gear = new DriveGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleKickDown(1000d, 1);

        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test()
    void should_throw_error_when_gear_initilized_with_higher_than_max() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        assertThrows(UnsupportedOperationException.class, () -> {
            new DriveGear(9, wrappedExternalSystems, 8);
        });
    }

    @Test()
    void should_throw_error_when_gear_initilized_with_lower_than_one() {
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems();
        assertThrows(UnsupportedOperationException.class, () -> {
            new DriveGear(0, wrappedExternalSystems, 8);
        });
    }
}