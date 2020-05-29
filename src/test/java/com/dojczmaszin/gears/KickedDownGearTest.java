package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KickedDownGearTest {

    @Test
    public void should_not_downshift_directly_after_kickdown(){
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        Gear gear = new KickedDownGear(7, wrappedExternalSystems, 8);
        Gear result = gear.handleKickDown(1000d, 1);

        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test
    public void should_shift_down_to_a_regular_gear(){
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        Gear gear = new KickedDownGear(7, wrappedExternalSystems, 8);
        Gear result = gear.shiftDown();

        assertEquals(new DriveGear(6, wrappedExternalSystems, 8), result);
    }

    @Test
    public void should_shift_up_to_a_regular_gear(){
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        Gear gear = new KickedDownGear(6, wrappedExternalSystems, 8);
        Gear result = gear.shiftUp();

        assertEquals(new DriveGear(7, wrappedExternalSystems, 8), result);
    }

    @Test
    public void should_not_shift_up_direclty_after_kick_down_when_rpm_increased_above_threshold(){
        WrappedExternalSystems wrappedExternalSystems = new WrappedExternalSystems(1001d);
        Gear gear = new KickedDownGear(6, wrappedExternalSystems, 8);
        Gear result = gear.handleRpmIncrease(999d, 1000d);

        assertEquals(new DriveGear(6, wrappedExternalSystems, 8), result);
    }
}