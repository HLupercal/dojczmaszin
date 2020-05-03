package thirdparty;

import thirdparty.raw.Gearbox;

public class WrappedGearbox {

    private Gearbox gearbox;
    private TransmissionMode transmissionMode;
    private static final int DEFAULT_MAX_GEAR = 8;
    private Gear currentGear;

    public WrappedGearbox() {
        this(DEFAULT_MAX_GEAR, TransmissionMode.NEUTRAL, new RegularGear(0));
    }

    public WrappedGearbox(int maxGear, TransmissionMode transmissionMode, RegularGear currentGear) {
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(maxGear);

        this.currentGear = currentGear;
        this.transmissionMode = transmissionMode;
    }

    public int getMaxGear() {
        return this.gearbox.getMaxDrive();
    }

    private Gear shiftUp() {
        if this.currentGear == this.curr

    }

    private Gear

    private RegularGear getCurrentGear(){
        Integer currentGear = (Integer) this.gearbox.getCurrentGear();
        return new RegularGear(currentGear);
    }
}
