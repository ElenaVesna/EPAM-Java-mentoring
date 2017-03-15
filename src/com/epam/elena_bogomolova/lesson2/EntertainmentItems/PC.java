package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.*;


public class PC extends Equipment implements FunItem, SleepMode, PlannedStartStop {

    public PC(long power, boolean isTurnedOn, String place) {
        super(power, isTurnedOn, place);
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void playVideo() {

    }
}
