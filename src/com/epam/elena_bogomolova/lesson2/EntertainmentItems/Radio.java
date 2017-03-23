package com.epam.elena_bogomolova.lesson2.EntertainmentItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;

public class Radio extends Equipment {

    public Radio(String place) {
        super(place);
        this.idlePower = 5;
        this.name = "JustRadio";
    }
}
