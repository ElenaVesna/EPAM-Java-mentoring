package com.epam.elena_bogomolova.lesson5.task1.EntertainmentItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

public class Radio extends Equipment {

    public Radio(Places place) {
        super(5, place,"JustRadio");
        this.power = idlePower;
    }
}
