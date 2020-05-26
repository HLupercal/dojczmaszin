package com.dojczmaszin.gears;

public interface Gear {
    //i guess a gear should handle shifting itself too
    public Gear shiftUp();
    public Gear shiftDown();
    public int getNativeGearNumber();
    public int getNativeModeNumber();
}
