package com.epam.elena_bogomolova.lesson5.task1.KitchenItems;

import com.epam.elena_bogomolova.lesson3.ErrorException;
import com.epam.elena_bogomolova.lesson3.WarningException;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.IFoodCooking;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Places;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Toaster extends Equipment implements IFoodCooking {

    private boolean isBreadIn = false;
    private int breadWeigh = 0;

    public Toaster(Places place) {
        super(5, place, "Figure_Toaster");
    }

    @Override
    public boolean checkForFood() {
        if (isBreadIn && breadWeigh < 100 && breadWeigh > 0) {
            return true;
        } else if (breadWeigh > 100){
            System.out.println("Toaster cannot bake more then 100 g, remove extra bread");
            return false;
        } else {
            return false;
        }
    }

    @Override
    public void addFood(int foodWeight) {
        System.out.println("input 'bread' and press Enter");
        Scanner sc = new Scanner(System.in);
        String food = sc.nextLine();
        if (food.equalsIgnoreCase("bread")) {
            breadWeigh = foodWeight;
            isBreadIn = true;
        } else System.out.println("Toaster can cook bread only");
    }

    @Override
    public void removeFood(int foodWeight) {
        breadWeigh -=foodWeight;
    }

    @Override
    public void startCooking() {
        if (checkForFood()) {
            power = idlePower + 60;
            idle = false;
        } else throw new ErrorException();
    }

    @Override
    public boolean foodReady() {
        System.out.println("Now you can enjoy your toast");
        power = idlePower;
        idle = true;
        return true;
    }

    public void makingToast() throws WarningException {
        if (state) {
            int weight = enterFoodWeight();
            while (!isBreadIn) {
                addFood(weight);
            }
            try {
                startCooking();
                foodReady();
            } finally {
                System.out.println("Toaster is turning off");
                turnOff();
                System.out.println("Now Toaster state: " + state);
            }
        } else throw new WarningException("Toaster is not turned on!");
    }

    private int enterFoodWeight() {
        System.out.println("input food weight (in grams) and press Enter");
        Scanner sc = new Scanner(System.in);
        int w = 0;
        try {
            w = sc.nextInt();
        } catch (InputMismatchException e) {
            new ErrorException().timeOfError();
            System.out.println("incorrect weight entered (should be integer)");
        } finally {
            System.out.println("no food added");
        }
        return w;
    }
}
