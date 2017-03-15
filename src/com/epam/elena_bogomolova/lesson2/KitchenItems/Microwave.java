package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;

public class Microwave implements IFoodCooking {

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
