package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface TransmissionMode {
    //so the idea is to use shiftUp and shiftDown here
    //transmission would hold the currentGear and create a new transmissionmode with each gear up or down
    Gear shiftUp();

    Gear shiftDown();
}
