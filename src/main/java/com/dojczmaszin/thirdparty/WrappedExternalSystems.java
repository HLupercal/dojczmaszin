package com.dojczmaszin.thirdparty;

public class WrappedExternalSystems {

    private ExternalSystems externalSystems;

    //assumed defaults
    public WrappedExternalSystems() {
        this.externalSystems = new ExternalSystems();
        this.externalSystems.setCurrentRpm(1000d);
    }

    public double getCurrentRpm() {
        return this.externalSystems.getCurrentRpm();
    }

    public double increaseRpm(double rpmDelta) {
        double newRpm = externalSystems.getCurrentRpm() + rpmDelta;
        this.externalSystems.setCurrentRpm(newRpm);
    }
}
