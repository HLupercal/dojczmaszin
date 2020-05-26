package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedGearbox;

public class ParkGear implements Gear {


    private WrappedGearbox wrappedGearbox;

    @Override
    public Gear shiftUp() {
        return new DriveGear(1, wrappedGearbox);
    }

    @Override
    public Gear shiftDown() {
        return new ReverseGear();
    }

    @Override
    public int getNativeGearNumber() {
        return 0;
    }

    @Override
    public int getNativeModeNumber() {
        return 2;
    }


}
