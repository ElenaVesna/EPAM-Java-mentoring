package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;

public class Microwave  extends Equipment implements IFoodCooking {

    private int foodInWeigh = 0;

    public Microwave(String place) {
        super(place);
        this.idlePower = 2;
        this.name = "Microwave-Pioneer";
    }

    @Override
    public boolean checkForFood() {
        return false;
    }

    @Override
    public void addFood(int foodWeight) {
        foodInWeigh += foodWeight;
    }

    @Override
    public void removeFood(int foodWeight) {
        if (foodWeight <= foodInWeigh) {
            foodInWeigh -= foodWeight;
        } else System.out.println("cannot remove move food then exists");
    }

    @Override
    public void startCooking() {
        if (foodInWeigh > 0) {
            System.out.println("cooking started");
            foodReady();
        }
    }

    @Override
    public boolean foodReady() {
        System.out.println("food ready, please take it off the Microwave");
        return true;
    }
}
