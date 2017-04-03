package com.epam.elena_bogomolova.lesson3;

import com.epam.elena_bogomolova.lesson3.EntertainmentItems.PC;
import com.epam.elena_bogomolova.lesson3.EntertainmentItems.PlayStation;
import com.epam.elena_bogomolova.lesson3.EntertainmentItems.Radio;
import com.epam.elena_bogomolova.lesson3.EntertainmentItems.TV;
import com.epam.elena_bogomolova.lesson3.KitchenItems.BreadMaker;
import com.epam.elena_bogomolova.lesson3.KitchenItems.Fridge;
import com.epam.elena_bogomolova.lesson3.KitchenItems.Microwave;
import com.epam.elena_bogomolova.lesson3.KitchenItems.Toaster;
import com.epam.elena_bogomolova.lesson3.OtherItems.AirConditioning;
import com.epam.elena_bogomolova.lesson3.OtherItems.Iron;
import com.epam.elena_bogomolova.lesson3.OtherItems.RobotCleaner;
import com.epam.elena_bogomolova.lesson3.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson3.Supplemental.IFoodActions;
import com.epam.elena_bogomolova.lesson3.Supplemental.Places;
import com.epam.elena_bogomolova.lesson3.Supplemental.VideoItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class SmartHome {

    public static void main(String[] args) {

        List<Equipment> smartHouse = new ArrayList<>();

        smartHouse.add(new Fridge(Places.kitchen));
        smartHouse.add(new PC(Places.room, "SuperPC"));
        smartHouse.add(new PlayStation(Places.room, "PS4"));
        smartHouse.add(new Radio(Places.bedroom));
        smartHouse.add(new TV(15, Places.room, "SmartTV"));
        smartHouse.add(new BreadMaker(Places.kitchen));
        smartHouse.add(new Microwave(Places.kitchen));
        smartHouse.add(new Toaster(Places.kitchen));
        smartHouse.add(new AirConditioning(Places.bedroom, "Bedroom_Cooler"));
        smartHouse.add(new Iron(Places.laundry, 55L));
        smartHouse.add(new RobotCleaner(Places.laundry));

        System.out.println("Hi, Smart House! I bought a lot food and I want to save and cook them");
        long currentPower = 0;
        for (Equipment eq : smartHouse) {
            if (eq instanceof IFoodActions) {
                eq.turnOn();
                currentPower += eq.getPower();
                String s = String.format("%1$s is turned on, it's current power is %2$o", eq.getName(), eq.getPower());
                System.out.println(s);
            }
        }
        System.out.printf("The current sum power is %o W", currentPower);
        System.out.println("\n");

        System.out.println("Hm... too much power, it's so expensive! Sort all my items based on their idle power!");

        class PlaceComparator implements Comparator<Equipment> {
            @Override
            public int compare (Equipment e1, Equipment e2) {
                return e1.getIdlePower() < e2.getIdlePower() ? -1 : e1.getIdlePower() == e2.getIdlePower() ? 0 : 1;
            }
        }

        sort(smartHouse, new  PlaceComparator());
        for (Equipment sh : smartHouse) {
            System.out.printf("%1$o W for %2$s \n", sh.getIdlePower(), sh.getName());
        }
        System.out.println();

        System.out.println("Ok, let's bake some bread");
        for (Equipment eq : smartHouse) {
            if (eq instanceof BreadMaker) {
                ((BreadMaker) eq).addFood(300);
                ((BreadMaker) eq).startCooking();
                ((BreadMaker) eq).foodReady();
            }
        }
        System.out.println();
        System.out.println("And now make a toast");
        for (Equipment eq : smartHouse) {
            if (eq instanceof Toaster) {
                ((Toaster) eq).addFood(50);
                ((Toaster) eq).startCooking();
            }
        }

        System.out.println();
        System.out.println("I get so bored... I want to watch some video. Remind me, what media devices do I have?");
        System.out.println("You have the following Video devices:");
        for (Equipment equipment : smartHouse) {
            if (equipment instanceof VideoItem) {
                System.out.println(equipment.getName());
            }
        }
        System.out.println("\n");

        System.out.println("OK, I wanna watch TV");
        for (Equipment eq : smartHouse) {
            if (eq instanceof TV) {
                eq.turnOn();
                ((TV) eq).playVideo();
            }
        }
        System.out.println();

        System.out.println("Please find working devices witch power is less then 50 W now");
        for (Equipment eq : smartHouse) {
            if (eq.getPower() < 50 && eq.isTurnedOn()) {
                String d = String.format("%1$s now uses power %2$o W (less then 50 W)", eq.getName(), eq.getPower());
                System.out.println(d);
            }
        }
        System.out.println();

        System.out.println("Please find all working kitchen devices");
        System.out.println("Now working device(s) is(are)");
        int notIdle = 0;
        for (Equipment eq : smartHouse) {
            if (eq.getPlace().equals(Places.kitchen) && !eq.isIdle()) {
                notIdle ++;
                System.out.println(eq.getName());
            }
        }
        if (notIdle == 0) {
            System.out.println("There are no working kitchen devices now");
        }

    }
}