package com.epam.elena_bogomolova.lesson2.Supplemental;

public interface PlannedActions {

    void planStart(long startTime);
    void planStop (long stopTime);
    void startSleepMode();
    void stopSleepMode();

    static void startSleepMode(int downtime) {
        if (downtime > 10) {
            System.out.println("I'm in sleeping mode");
        }
    }
}
