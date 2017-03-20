package com.epam.elena_bogomolova.lesson2.OtherItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.ICleaningActions;
import com.epam.elena_bogomolova.lesson2.Supplemental.PlannedActions;

public class RobotCleaner extends Equipment implements PlannedActions, ICleaningActions {

    public RobotCleaner(String place) {
        super(place);
        this.power = 200;
        this.place = "room";
    }

    @Override
    public void planStart(long startTime) {

    }

    @Override
    public void planStop(long stopTime) {

    }

    @Override
    public void startSleepMode() {

    }

    @Override
    public void stopSleepMode() {

    }

    @Override
    public void startRoomCleaning() {

    }

    @Override
    public void startIroning() {

    }
}
