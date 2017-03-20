package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;

public class Toaster extends Equipment implements IFoodCooking {


    public Toaster(String place) {
        super(place);
    }

    @Override
    public boolean checkForFood() {
        return false;
    }

    @Override
    public void addFood(int foodWeight) {

    }

    @Override
    public void removeFood(int foodWeight) {

    }

    @Override
    public void startCooking() {

    }

    @Override
    public boolean foodReady() {
        return false;
    }
}
