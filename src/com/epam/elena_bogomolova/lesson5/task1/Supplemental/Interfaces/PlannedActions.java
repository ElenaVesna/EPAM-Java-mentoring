package com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.WarningException;

public interface PlannedActions {

    void planStart(long startTime);
    void planStop(long stopTime) throws WarningException;
    void startSleepMode();
    void stopSleepMode();

}
