package com.dojczmaszin.gears;

import com.dojczmaszin.thirdparty.WrappedExternalSystems;

public class LoudDownshiftingGear extends DriveGear {

    private int number;
    private WrappedExternalSystems wrappedExternalSystems;
    private int maxNumber;

    public LoudDownshiftingGear(int number, WrappedExternalSystems wrappedExternalSystems, int maxNumber) {
        super(number, wrappedExternalSystems, maxNumber);
    }

    @Override
    public Gear shiftDown() {
        if (this.number == 1) {
            return new NeutralGear(this.wrappedExternalSystems, this.maxNumber);
        }
        System.out.println("It's so loud that i can't hear poverty");
        return new LoudDownshiftingGear(this.number - 1, this.wrappedExternalSystems, this.maxNumber);
    }

}
