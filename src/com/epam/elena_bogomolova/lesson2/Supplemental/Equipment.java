package com.epam.elena_bogomolova.lesson2.Supplemental;

public abstract class Equipment {
    protected long power;
    protected String place;
    protected boolean state = false;

    public Equipment(long power, String place, boolean state) {
        this.power = power;
        this.state = state;
        this.place = place;
    }

    public long getPower() {
        return power;
    }

    public Equipment(String place) {
        this.place = place;
    }

    public boolean turnOn() {
        return state = true;
    }

    public boolean turnOff() {
        return state = false;
    }

    public void move(String newPlace) {
        place = newPlace;
    }

}
