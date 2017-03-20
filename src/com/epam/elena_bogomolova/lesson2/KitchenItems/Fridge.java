package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodSaving;
import com.epam.elena_bogomolova.lesson2.Supplemental.ISetTemperature;


public class Fridge extends Equipment implements IFoodSaving, ISetTemperature {

    protected int foodWeight = 0;
    private int currentTemperature = 20;
    private long basicPower = 320;

    public Fridge(String place) {
        super(place);
//        this.place = "kitchen";
        this.power = basicPower;
    }

    @Override
    public boolean checkForFood() {
        if (foodWeight == 0) {
            return false;
        } else return true;
    }

    @Override
    public void addFood(int weight) {
        foodWeight += weight;
    }

    @Override
    public void removeFood(int weight) {
        if (weight <= foodWeight) {
            foodWeight -= weight;
        } else System.out.println("cannot remove move food then exists");
    }

    @Override
    public void startFreezing(int temperature) {
        System.out.println("freezing started");
        long freezingPower = 0;
        while (temperature < currentTemperature) {
            currentTemperature -= 1;
            freezingPower += 10;
        }
        this.power = basicPower + freezingPower;
    }

    @Override
    public boolean foodFrozen(int temperature) {
        if (currentTemperature <= temperature) {
            return true;
        } else return false;
    }

    @Override
    public void setTemperature(int degree, int timeToReachTemperature) {

    }
}
