package com.epam.elena_bogomolova.lesson5.task1.OtherItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

public class Iron extends Equipment {

    public Iron(Places place, Long power) {
        super(power, Places.laundry,  "Vapor Iron");
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
