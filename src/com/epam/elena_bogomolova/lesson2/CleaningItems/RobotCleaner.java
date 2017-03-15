package com.epam.elena_bogomolova.lesson2.CleaningItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.PlannedStartStop;

public class RobotCleaner extends Equipment implements PlannedStartStop {
    public RobotCleaner(long power, boolean isTurnedOn, String place) {
        super(power, isTurnedOn, place);
    }

    @Override
    public void planStart(long startTime) {

    }

    @Override
    public void planStop(long stopTime) {

    }
}
