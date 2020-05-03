package com.dojczmaszin.thirdparty;

import com.dojczmaszin.gears.Gear;
import com.dojczmaszin.gears.DriveGear;
import com.dojczmaszin.gears.NeutralGear;
import com.dojczmaszin.thirdparty.raw.Gearbox;
import com.dojczmaszin.transmission.Neutral;
import com.dojczmaszin.transmission.TransmissionMode;

public class WrappedGearbox {

    private Gearbox gearbox;
    private TransmissionMode transmissionMode;
    private static final int DEFAULT_MAX_GEAR = 8;
    private Gear currentGear;

    public WrappedGearbox() {
        this(DEFAULT_MAX_GEAR, new Neutral(), new NeutralGear(DEFAULT_MAX_GEAR));
    }

    private WrappedGearbox(int maxGear, TransmissionMode transmissionMode, Gear currentGear) {
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(maxGear);

        this.currentGear = currentGear;
        this.transmissionMode = transmissionMode;
    }

    public int getMaxGear() {
        return this.gearbox.getMaxDrive();
    }

//    private Gear shiftUp() {
//        if this.currentGear == this.curr
//
//    }


    private Gear getCurrentGear(){
        return this.currentGear;
    }
}
