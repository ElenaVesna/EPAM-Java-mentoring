package com.epam.elena_bogomolova.lesson3.EntertainmentItems;

import com.epam.elena_bogomolova.lesson3.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson3.Supplemental.Places;

public class Radio extends Equipment {

    public Radio(Places place) {
        super(5, place, "JustRadio");
        this.power = idlePower;
    }
}
