package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

public abstract class GearDecorator implements Gear {

    private Gear gear;

    public GearDecorator(Gear gear) {
        this.gear = gear;
    }

    @Override
    public Gear shiftUp() {
        return gear.shiftUp();
    }

    @Override
    public Gear shiftDown() {
        return gear.shiftDown();
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold) {
        return gear.handleRpmIncrease(shiftDownRpmThreshold, shiftUpRpmThreshold);
    }

    @Override
    public Gear handleKickDown(double kickDownRpmThreshold, int howManyDownshifts) {
        return gear.handleKickDown(kickDownRpmThreshold, howManyDownshifts);
    }

    @Override
    public Gear handleRpmDecrease(double shiftDownRpmThreshold) {
        return gear.handleRpmDecrease(shiftDownRpmThreshold);
    }

    @Override
    public int getNumber() {
        return gear.getNumber();
    }

    @Override
    public int getNativeGearNumber() {
        return gear.getNumber();
    }

    @Override
    public int getNativeModeNumber() {
        return 0;
    }


}
