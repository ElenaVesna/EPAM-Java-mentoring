package com.epam.elena_bogomolova.lesson2.KitchenItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodCooking;

import java.util.Scanner;

public class Toaster extends Equipment implements IFoodCooking {

    private boolean isFoodIn = false;
    private int breadWeigh = 0;

    public Toaster(String place) {
        super(place);
        this.idlePower = 5;
        this.name = "Figure Toaster";
    }

    @Override
    public boolean checkForFood() {
        if (isFoodIn && breadWeigh < 100) {
            return true;
        } else {
            System.out.println("Toaster cannot bake more then 100 g, remove extra bread");
            return false;
        }
    }

    @Override
    public void addFood(int foodWeight) {
        System.out.println("input 'bread' and press Enter");
        Scanner sc = new Scanner(System.in);
        String food = sc.nextLine();
        if (food.equalsIgnoreCase("bread") && foodWeight > 0) {
            breadWeigh = foodWeight;
            isFoodIn = true;
        } else System.out.println("Toaster can cook bread only");
    }

    @Override
    public void removeFood(int foodWeight) {
        breadWeigh +=foodWeight;
    }

    @Override
    public void startCooking() {
        power = idlePower + 60;
    }

    @Override
    public boolean foodReady() {
        System.out.println("Now you can enjoy your toast");
        power = idlePower;
        return true;
    }
}
