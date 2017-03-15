package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodSaving;


public class Fridge extends Equipment implements IFoodSaving {

    public int productsWeight = 0;

    public Fridge(long power, boolean isTurnedOn, String place) {
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
    public void startFreezing() {

    }
}
