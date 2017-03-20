package com.epam.elena_bogomolova.lesson2;

import com.epam.elena_bogomolova.lesson2.KitchenItems.Fridge;

public class SmartHome {
    public static void main(String[] args) {
        Fridge fridge = new Fridge("kitchen");
        fridge.addFood(5);
        fridge.turnOn();
        System.out.println("I'm using " + fridge.getPower() + " power");
        fridge.startFreezing(10);
        System.out.println("I'm using feezing power " + fridge.getPower());
    }




}
