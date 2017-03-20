package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.FunItem;

public class TV extends Equipment implements FunItem {


    public TV(String place) {
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
        System.out.println("I cannot play games");
    }
}
