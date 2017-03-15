package com.epam.elena_bogomolova.lesson2.Supplemental;

public class Equipment {
    private long power;
    private boolean isTurnedOn;
    private String place;
    private long weight;

    public Equipment(long power, boolean isTurnedOn, String place) {
        this.power = power;
        this.isTurnedOn = isTurnedOn;
        this.place = place;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    public void move(String newPlace) {
        place = newPlace;
    }

}
