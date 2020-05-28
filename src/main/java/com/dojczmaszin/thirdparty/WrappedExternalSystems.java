package com.dojczmaszin.thirdparty;

public class WrappedExternalSystems {

    private ExternalSystems externalSystems;

    //assumed defaults
    public WrappedExternalSystems() {
        this.externalSystems = new ExternalSystems();
        this.externalSystems.setCurrentRpm(1000d);
    }

    public WrappedExternalSystems(double rpm){
        this.externalSystems = new ExternalSystems();
        this.externalSystems.setCurrentRpm(rpm);
    }


    public double getCurrentRpm() {
        return this.externalSystems.getCurrentRpm();
    }

    public void increaseRpm(double rpmDelta) {
        double newRpm = externalSystems.getCurrentRpm() + rpmDelta;
        this.externalSystems.setCurrentRpm(newRpm);
    }

    public void setCurrentRpm(double newRpm) {
        this.externalSystems.setCurrentRpm(newRpm);
    }
}
