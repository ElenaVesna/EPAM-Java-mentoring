package com.epam.elena_bogomolova.lesson5.task1.Supplemental;

import com.epam.elena_bogomolova.lesson3.WarningException;

public interface PlannedActions {

    void planStart(long startTime);
    void planStop(long stopTime) throws WarningException;
    void startSleepMode();
    void stopSleepMode();

}
