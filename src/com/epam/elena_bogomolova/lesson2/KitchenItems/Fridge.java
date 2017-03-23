package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodSaving;
import com.epam.elena_bogomolova.lesson2.Supplemental.ISetTemperature;

public class Fridge extends Equipment implements IFoodSaving, ISetTemperature {

    private int foodInFridgeWeight = 0;
    private int fridgeTemperature = 20;

    public Fridge(String place) {
        super(place);
        this.idlePower = 320;
        this.name = "NewFridge";
    }

    @Override
    public boolean checkForFood() {
        return foodInFridgeWeight > 0;
    }

    @Override
    public void addFood(int foodWeight) {
        foodInFridgeWeight += foodWeight;
        System.out.println("now there are " + foodInFridgeWeight + " g of food in the fridge");
    }

    @Override
    public void removeFood(int weight) {
        if (weight <= foodInFridgeWeight) {
            foodInFridgeWeight -= weight;
        } else System.out.println("cannot remove move food then exists");
    }

    @Override
    public void startFreezing(int temperature) {
        System.out.println("freezing started");
        long freezingPower = 0;
        while (temperature < fridgeTemperature) {
            fridgeTemperature -= 1;
            freezingPower += 10;
        }
        power = idlePower + freezingPower;
    }

    @Override
    public boolean foodFrozen(int temperature) {
        if (fridgeTemperature <= temperature) {
            power = idlePower;
            return true;
        } else return false;
    }

    @Override
    public void setTemperature(int degree) {
        if (fridgeTemperature > degree) {
            startFreezing(degree);
        } else System.out.println("Current fridge temperature is " + degree + " degrees");
    }
}
