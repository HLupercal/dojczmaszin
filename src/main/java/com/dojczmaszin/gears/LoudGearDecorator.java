package com.dojczmaszin.gears;

import java.util.Objects;

public class LoudGearDecorator extends GearDecorator {

    private Gear gear;

    public LoudGearDecorator(Gear gear) {
        super(gear);
        this.gear = gear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoudGearDecorator that = (LoudGearDecorator) o;
        return Objects.equals(gear, that.gear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gear);
    }

    @Override
    public Gear shiftDown() {
        System.out.println("I'm way louder than metallica, even before before they got old");
        return super.shiftDown();
    }

    @Override
    public Gear handleRpmIncrease(double shiftDownRpmThreshold, double shiftUpRpmThreshold) {
        //clunky AF, need to inject behavior directly somehow
        Gear result = super.handleRpmIncrease(shiftDownRpmThreshold, shiftUpRpmThreshold);
        if (result.getNumber() < super.getNumber()) {
            System.out.println("I'm way louder than metallica, even before before they got old");
        }
        return new LoudGearDecorator(result);
    }
}
