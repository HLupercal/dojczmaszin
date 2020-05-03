package com.dojczmaszin.thirdparty.raw;

public class ExternalSystems {

    private double currentRpm;
    private double angularSpeed;
    private Lights lights = new Lights();

    ExternalSystems() {

    }

    public double getCurrentRpm() {
        return currentRpm;
    }

    public void setCurrentRpm(double currentRpm) {
        this.currentRpm = currentRpm;
    }

    public double getAngularSpeed() {
        return angularSpeed;
    }

    public void setAngularSpeed(double angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    public Lights getLights() {
        return lights;
    }

    public void setLights(Lights lights) {
        this.lights = lights;
    }

}

class SoundModule {
    void makeSound(int db) {

    }
}
