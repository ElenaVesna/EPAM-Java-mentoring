package com.epam.elena_bogomolova.lesson2;

import com.epam.elena_bogomolova.lesson2.EntertainmentItems.PC;
import com.epam.elena_bogomolova.lesson2.EntertainmentItems.PlayStation;
import com.epam.elena_bogomolova.lesson2.EntertainmentItems.Radio;
import com.epam.elena_bogomolova.lesson2.EntertainmentItems.TV;
import com.epam.elena_bogomolova.lesson2.KitchenItems.BreadMaker;
import com.epam.elena_bogomolova.lesson2.KitchenItems.Fridge;
import com.epam.elena_bogomolova.lesson2.KitchenItems.Microwave;
import com.epam.elena_bogomolova.lesson2.KitchenItems.Toaster;
import com.epam.elena_bogomolova.lesson2.OtherItems.AirConditioning;
import com.epam.elena_bogomolova.lesson2.OtherItems.Iron;
import com.epam.elena_bogomolova.lesson2.OtherItems.RobotCleaner;
import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.IFoodActions;
import com.epam.elena_bogomolova.lesson2.Supplemental.VideoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartHome {

    public static void main(String[] args) {

        Equipment[] smartHouse = new Equipment[11];

        smartHouse[0] = new Fridge("kitchen");
        smartHouse[1] = new PC("room", "SuperPC");
        smartHouse[2] = new PlayStation("room", "PS4");
        smartHouse[3] = new Radio("bedroom");
        smartHouse[4] = new TV(15, "room", "SmartTV");
        smartHouse[5] = new BreadMaker("kitchen");
        smartHouse[6] = new Microwave("kitchen");
        smartHouse[7] = new Toaster("kitchen");
        smartHouse[8] = new AirConditioning("bedroom", "Bedroom Cooler");
        smartHouse[9] = new Iron("laundry");
        smartHouse[10] = new RobotCleaner("laundry");

        System.out.println("Hi, Smart House! I bought a lot food and I want to save and cook them");
        long currentPower = 0;
        for (Equipment equipment : smartHouse) {
            if (equipment instanceof IFoodActions) {
                equipment.turnOn();
                currentPower += equipment.getPower();
                System.out.println(equipment.getName() + " is turned on, it's current power is " + equipment.getPower());
            }
        }
        System.out.println("The current sum power is " + currentPower + " W");
        System.out.println();

        System.out.println("Hm... too much power, it's so expensive! Sort all my items based on their idle power!");
        List<Long> powersList = new ArrayList<>();
        for (Equipment equipment : smartHouse) {
            powersList.add(equipment.getIdlePower());
        }

//        Arrays.sort(smartHouse);
//        for (Equipment equipment : smartHouse) {
//            System.out.println(equipment.getIdlePower() + " W has " + equipment.getName());
//            }
//        }


        Collections.sort(powersList);
        for (Long powers : powersList) {
            for (Equipment equipment : smartHouse) {
                long eqPower = equipment.getIdlePower();
                if (eqPower == powers) {
                    System.out.println(powers + " W has " + equipment.getName());
                }
            }
        }

        System.out.println();

        System.out.println("Ok, let's bake some bread");
        ((BreadMaker) smartHouse[5]).addFood(300);
        ((BreadMaker) smartHouse[5]).startCooking();

        System.out.println();
        System.out.println("I get so bored... I want to watch some video. Remind me, what media devices do I have?");
        System.out.println("You have the following Video devices:");
        for (Equipment equipment : smartHouse) {
            if (equipment instanceof VideoItem) {
                System.out.print(equipment.getName() + ", ");
            }
        }
        System.out.println("\n");
        System.out.println("Please find working devices witch power is less then 50 W now");


    }
}
