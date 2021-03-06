package com.epam.elena_bogomolova.lesson3.EntertainmentItems;

import com.epam.elena_bogomolova.lesson3.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson3.Supplemental.Places;
import com.epam.elena_bogomolova.lesson3.Supplemental.PlannedActions;
import com.epam.elena_bogomolova.lesson3.Supplemental.VideoItem;
import com.epam.elena_bogomolova.lesson3.WarningException;

public class TV extends Equipment implements VideoItem, PlannedActions {

    public TV(long idlePower, Places place, String name) {
        super(idlePower, place, name);
    }

    @Override
    public void playVideo() {
        power = idlePower + 25;
        idle = false;
        System.out.println("1st channel shows 'Frozen' now. Enjoy!");
    }

    @Override
    public void planStart(long startTime) {
        if (startTime >= System.currentTimeMillis()) {
            turnOn();
        }
    }

    @Override
    public void planStop(long stopTime) throws WarningException {
        if (stopTime >= System.currentTimeMillis()) {
            System.out.println("TV is turning off. Goodbye!");
            turnOff();
        }
    }

    @Override
    public void startSleepMode() {
        if (state) {
            System.out.println("TV is in sleep mode now");
            idle = true;
            power = idlePower;
        } else System.out.println("TV cannot sleep when it is not turned on");
    }

    @Override
    public void stopSleepMode() {
        System.out.println("TV is awaken");
        power = idlePower;
    }
}
