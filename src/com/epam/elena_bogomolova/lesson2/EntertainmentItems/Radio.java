package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.MusicItem;

public class Radio extends Equipment implements MusicItem {

    public Radio(String place) {
        super(place);
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void playGame() {

    }
}