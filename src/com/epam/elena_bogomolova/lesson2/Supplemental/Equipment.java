package com.epam.elena_bogomolova.lesson2.Supplemental;

public abstract class Equipment {
    protected long power;
    protected String place;
//    protected long weight;
//    protected boolean stateOn;

    public Equipment(long power, String place) {
        this.power = power;
//        this.stateOn = stateOn;
        this.place = place;
//        this.weight = weight;
    }

//    public Equipment (long power, String place, long weight) {
//        this(power, false, place, weight);
//    }

    public boolean turnOn() {
        return true;
    }

    public boolean turnOff() {
        return false;
    }

    public void move(String newPlace) {
        place = newPlace;
    }

    public void startSleepMode(int downtime) {
        if (downtime > 10) {
            System.out.println("I'm in sleeping mode");
        }
    }
}
