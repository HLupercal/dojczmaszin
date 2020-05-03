package thirdparty;

import thirdparty.raw.Gearbox;

public class WrappedGearbox {

    private final Gearbox gearbox;
    private final TransmissionMode transmissionMode;
    private static final int DEFAULT_MAX_GEAR = 8;

    public WrappedGearbox() {
        this.transmissionMode = TransmissionMode.NEUTRAL;
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(DEFAULT_MAX_GEAR);
    }

    public WrappedGearbox(int maxGear, TransmissionMode transmissionMode) {
        this.gearbox = new Gearbox();
        this.gearbox.setCurrentGear(0);
        this.gearbox.setMaxDrive(maxGear);
        this.transmissionMode = transmissionMode;
    }

    public int getMaxGear() {
        return this.gearbox.getMaxDrive();
    }

}
