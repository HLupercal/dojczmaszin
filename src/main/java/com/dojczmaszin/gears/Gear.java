package com.dojczmaszin.gears;

public interface Gear {
    //i guess a gear should handle shifting itself too
    public Gear shiftUp();
    public Gear shiftDown();
    public Gear handleRpmIncrease(double shiftDownThreshold, double shiftUpThreshold);
//    public Gear handleRpmDecrease(double rpmThreshold);
//    public Gear handleRpmIncrease(double rpmThreshold);
    public int getNativeGearNumber();
    public int getNativeModeNumber();
}
