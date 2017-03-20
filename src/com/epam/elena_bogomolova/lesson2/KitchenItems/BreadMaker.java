package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;

public class BreadMaker extends Equipment implements IFoodCooking {

    protected boolean stateOn;
    private boolean foodIn;
    private long cookTime;

    public BreadMaker(long power, String place) {
        super(power, place);
        this.power = 20;
        this.place = "kitchen";
//        this.weight = 5;
    }

    @Override
    public boolean checkForFood() {
        return false;
    }

    @Override
    public void setTemperature(int degree) {

    }

    @Override
    public void addFood(int foodWeight) {
        System.out.println("put flower, butter, sugar, ");
    }

    @Override
    public void removeFood(int foodWeight) {
    }

    @Override
    public void startCooking() {

    }

    @Override
    public boolean foodReady() {
        System.out.println("Your cake is baked, enjoy!");
        return true;
    }
}
