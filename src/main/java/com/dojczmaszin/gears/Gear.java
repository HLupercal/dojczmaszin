package com.dojczmaszin.gears;

public interface Gear {
    //i guess a gear should handle shifting itself too
    public Gear shiftUp();
    public Gear shiftDown();
    public Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold);
    public int getNativeGearNumber();
    public int getNativeModeNumber();
    Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts);

    public Gear handleRpmDecrease(double shiftDownRpmThreshold);
}
