package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;
import com.dojczmaszin.thirdparty.WrappedGearbox;

public class MaxDriveGear extends DriveGear {
    private WrappedGearbox wrappedGearbox;
    private WrappedExternalSystems wrappedExternalSystems;
    private int number;

    public MaxDriveGear(int maxGear, WrappedGearbox wrappedGearbox, WrappedExternalSystems wrappedExternalSystems) {
        super(maxGear, wrappedGearbox, wrappedExternalSystems);
        this.number = maxGear;
    }


    @Override
    public Gear shiftUp() {
        return this;
    }

    @Override
    public Gear shiftDown() {
        return new DriveGear(this.number--, this.wrappedGearbox, this.wrappedExternalSystems);
    }


}
