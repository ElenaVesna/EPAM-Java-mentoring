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

public class SmartHome {
    public static void main(String[] args) {

        Equipment[] smartHouse = new Equipment[11];

        smartHouse[0] = new Fridge("kitchen");
        smartHouse[1] = new PC("room");
        smartHouse[2] = new PlayStation("room");
        smartHouse[3] = new Radio("bedroom");
        smartHouse[4] = new TV("room");
        smartHouse[5] = new BreadMaker("kitchen");
        smartHouse[6] = new Microwave("kitchen");
        smartHouse[7] = new Toaster("kitchen");
        smartHouse[8] = new AirConditioning("bedroom");
        smartHouse[9] = new Iron("laundry");
        smartHouse[10] = new RobotCleaner("laundry");

        Fridge fridge = new Fridge("kitchen");
        fridge.addFood(5);
        fridge.turnOn();
        System.out.println("I'm using " + fridge.getPower() + " power");
        fridge.startFreezing(10);
        System.out.println("I'm using freezing power " + fridge.getPower());
    }




}
