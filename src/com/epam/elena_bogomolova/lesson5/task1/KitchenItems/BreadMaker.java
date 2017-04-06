package com.epam.elena_bogomolova.lesson5.task1.KitchenItems;

import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.IFoodCooking;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

public class BreadMaker extends Equipment implements IFoodCooking {

    private int foodInAmount = 0;

    public BreadMaker(Places place) {
        super(20, place, "HomeBaker");
    }

    @Override
    public boolean checkForFood() {
        if (foodInAmount < 100) {
            System.out.println("too small amount of ingredients");
            return false;
        } else if (foodInAmount > 1500) {
            System.out.println("too much ingredients, BreadMaker cannot cook more then 1,5 kg bread");
            return false;
        } else {
            System.out.println("Products are in, now you can start baking");
            return true;
        }
    }

    @Override
    public void addFood(int foodWeight) {
        System.out.println("put flower, butter, sugar, eggs...");
        foodInAmount += foodWeight;
    }

    @Override
    public void removeFood(int foodWeight) {
        if (foodWeight <= foodInAmount) {
            foodInAmount -= foodWeight;
        } else System.out.println("You cannot remove more food that exists in!");
    }

    @Override
    public void startCooking() {
        if (checkForFood()) {
            power = idlePower + 45;
            System.out.println("Bread making started");
            idle = false;
        } else System.out.println("Something went wrong, check for food");
    }

    @Override
    public boolean foodReady() {
        System.out.println("Your cake is baked, enjoy!");
        power = idlePower;
        idle = true;
        return true;
    }
}
