package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.FunItem;

public class Radio extends Equipment implements FunItem {
    public Radio(long power, boolean isTurnedOn, String place) {
        super(power, isTurnedOn, place);
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void playVideo() {

    }
}
