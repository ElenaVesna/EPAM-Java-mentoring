package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;
import com.epam.elena_bogomolova.lesson2.Supplemental.PlannedStartStop;

public class BreadMaker extends Equipment implements IFoodCooking, PlannedStartStop {
    public BreadMaker(long power, boolean isTurnedOn, String place) {
        super(power, isTurnedOn, place);
    }

    @Override
    public boolean checkForFood() {
        return false;
    }

    @Override
    public void setTemperature(int degree) {

    }

    @Override
    public void startCooking() {

    }

    @Override
    public void foodReady() {

    }
}
