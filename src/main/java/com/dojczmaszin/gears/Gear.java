package com.dojczmaszin.gears;

public interface Gear {
    //i guess a gear should handle shifting itself too
    Gear shiftUp();

    Gear shiftDown();

    Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold);

    Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts);

    Gear handleRpmDecrease(double shiftDownRpmThreshold);

    int getNumber();

    int getNativeGearNumber();

    int getNativeModeNumber();
}
