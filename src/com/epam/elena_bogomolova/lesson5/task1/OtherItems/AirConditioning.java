package com.epam.elena_bogomolova.lesson5.task1.OtherItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces.ISetTemperature;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

public class AirConditioning extends Equipment implements ISetTemperature {

    private int roomTemperature = 18;

    public AirConditioning(Places place, String name) {
        super(17, Places.room, name);
    }

    @Override
    public void setTemperature(int degree) {
        int temperatureGap = roomTemperature - degree;
        if (temperatureGap < 0) {
            System.out.println("You should use heater to increase room temperature");
        } else if (temperatureGap < 5) {
            power = idlePower*2;
            roomTemperature = degree;
        } else if (temperatureGap < 15) {
            power = idlePower*3;
            roomTemperature = degree;
        } else System.out.println("You'd better move to the North Pole! :)");
    }
}
