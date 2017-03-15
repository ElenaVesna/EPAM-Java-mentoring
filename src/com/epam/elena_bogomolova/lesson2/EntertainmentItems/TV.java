package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.FunItem;
import com.epam.elena_bogomolova.lesson2.Supplemental.SleepMode;

public class TV extends Equipment implements FunItem, SleepMode {

    public TV(long power, boolean isTurnedOn, String place) {
        super(power, isTurnedOn, place);
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void playVideo() {

    }
}
