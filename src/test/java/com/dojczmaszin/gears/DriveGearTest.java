package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriveGearTest {

    @Test
    void shiftUp() {
    }

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
    void handleRpmDecrease() {
    }

    @Test
    void handleRpmIncrease() {
    }

    @Test
    void handleKickDown() {
    }
}