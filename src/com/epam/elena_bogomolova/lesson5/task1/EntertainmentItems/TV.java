package com.epam.elena_bogomolova.lesson5.task1.EntertainmentItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.WarningException;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces.PlannedActions;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces.VideoItem;

import java.io.Serializable;

public class TV extends Equipment implements VideoItem, PlannedActions, Serializable {

    public TV(String name) {
        super(15, Places.room, name, true);
    }

    @Override
    public void playVideo() {
        power = idlePower + 25;
        idle = false;
        System.out.println("1st channel shows 'Frozen' now. Enjoy!");
    }

    @Override
    public void stopVideo() {
        System.out.println("Program translation stopped, TV is in waiting mode now");
        power = idlePower;
        idle = true;
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
