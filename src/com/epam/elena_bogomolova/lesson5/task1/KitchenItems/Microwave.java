package com.epam.elena_bogomolova.lesson5.task1.KitchenItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.IFoodCooking;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

public class Microwave  extends Equipment implements IFoodCooking {

    private int foodInWeigh = 0;

    public Microwave(Places place) {
        super(2, place, "Microwave-Pioneer");
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
            power = idlePower*20;
            idle = false;
        }
    }

    @Override
    public boolean foodReady() {
        System.out.println("food ready, please take it off the Microwave");
        power = idlePower;
        idle = true;
        return true;
    }
}
