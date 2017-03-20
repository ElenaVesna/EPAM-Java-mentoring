package com.epam.elena_bogomolova.lesson2.Supplemental;

public interface PlannedActions {

    void planStart(long startTime);
    void planStop (long stopTime);
    void startSleepMode();
    void stopSleepMode();

}
