package com.example.theo.dlcapp.model;

public class Plafonnier {

    private boolean is_on;
    private int intensity;

    public Plafonnier() {
        this.is_on = false;
        this.intensity = 0;
    }

    public boolean isIs_on() {
        return is_on;
    }

    public void setIs_on(boolean is_on) {
        this.is_on = is_on;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
