package com.epam.elena_bogomolova.lesson2.OtherItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.PlannedActions;

public class RobotCleaner extends Equipment implements PlannedActions {

    public RobotCleaner(String place) {
        super(place);
        this.idlePower = 10;
        this.name = "Robot Cleaner";
    }

    @Override
    public void planStart(long startTime) {
        if (startTime >= System.currentTimeMillis()) {
            if (state) {
                System.out.println("Starting to clean your floors");
                power = 200;
            } else System.out.println("Cannot plan start for turned off Robot Cleaner");
        }
    }

    @Override
    public void planStop(long stopTime) {
        if (stopTime >= System.currentTimeMillis()) {
            power = idlePower;
            System.out.println("Floors cleaning stopped as planned");
        }
    }

    @Override
    public void startSleepMode() {
        if (state) {
            System.out.println("Robot Cleaner is in sleep mode now");
            idle = true;
            power = idlePower;
        } else System.out.println("Robot Cleaner cannot sleep when it is not turned on");
    }

    @Override
    public void stopSleepMode() {
        System.out.println("Robot Cleaner is ready to clean your floor");
        power = idlePower;
    }

    public void startRoomCleaning() {
        System.out.println("Your floors are cleaned now");
        power = 200;
    }

}
