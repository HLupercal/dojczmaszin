package com.dojczmaszin.thirdparty;

public class WrappedExternalSystems {

    private ExternalSystems externalSystems;

    public WrappedExternalSystems() {
        this.externalSystems = new ExternalSystems();
        this.externalSystems.setCurrentRpm(1000d);
    }

    public double getCurrentRpm() {
        return this.externalSystems.getCurrentRpm();
    }
}
