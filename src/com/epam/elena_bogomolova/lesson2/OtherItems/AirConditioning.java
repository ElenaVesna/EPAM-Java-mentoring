package com.epam.elena_bogomolova.lesson2.OtherItems;


import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.ISetTemperature;

public class AirConditioning extends Equipment implements ISetTemperature {

    public AirConditioning(String place) {
        super(place);
        this.place = "room";
    }

    @Override
    public void setTemperature(int degree, int timeToReachTemperature) {
        if (timeToReachTemperature < 10) {
            this.power = 400;
        } else this.power = 350;
        System.out.println("Now room temperature is " + degree + "degree(s)");
    }
}
