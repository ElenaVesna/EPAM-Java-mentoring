package com.epam.elena_bogomolova.lesson2.OtherItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;

public class Iron extends Equipment {

    public Iron(String place) {
        super(place);
        this.idlePower = power;
        this.name = "Vapor Iron";
    }

    public void startIroning(int ironingTemperature) {
        System.out.println("Your clothes will be ironed soon");
        if (ironingTemperature < 150) {
            power = 300;
        } else if (ironingTemperature < 300) {
            power = 380;
        } else System.out.println("Ironing temperature is too high!");

    }
}
