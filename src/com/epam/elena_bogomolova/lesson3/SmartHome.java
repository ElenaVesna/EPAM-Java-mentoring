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
import com.epam.elena_bogomolova.lesson3.Supplemental.MusicItem;
import com.epam.elena_bogomolova.lesson3.Supplemental.Places;
import com.epam.elena_bogomolova.lesson3.Supplemental.Units;


public class SmartHome {

    private static final String INITIALIZATION = "Hi, Smart House!";
    private static final String ERRMSG = "---Error message: ";

    public static void main(String[] args) throws WarningException {

        System.out.println(INITIALIZATION);

//        Playstation creation
        System.out.println("I bought a new Playstation!");
        Equipment PS = createUnit(Units.Playstation, Places.room);
//        get TurnOff exception
        System.out.println("\n Turn PS off");
        turnOffUnit(PS);

//        try to create unit with no implemented class - catch NullPointerException
        System.out.println("\n Let's add electronic clock in the kitchen");
        createUnit(Units.ElectronicClock, Places.kitchen);

//        you may try to move to incorrect place
        System.out.println("\n Let's move Playstation to another place");
        PS.move();

//        PC creation
        System.out.println("\nAdd a computer to room equipments");
        Equipment PC = createUnit(Units.PC, Places.room);
        System.out.println("I want to listen to music!");
        try {
            ((MusicItem)PC).playMusic();
        } catch (WarningException e) {
            System.out.println("---Error: incorrect album number chosen");
        }
    }

    private static void turnOffUnit(Equipment eq) throws WarningException {
        try {
            eq.turnOff();
        } catch (ErrorException e) {
            new ErrorException().timeOfError();
            System.out.println(ERRMSG + eq.getName() + " is already turned off");
        }
    }

    private static Equipment createUnit(Units unitType, Places place) {
        Equipment newEq = null;
        switch (unitType) {
            case Fridge: newEq = new Fridge(place);
                break;
            case PC: newEq = new PC(place, "SuperPC");
                break;
            case TV: newEq = new TV(15, place, "SmartTV");
                break;
            case Iron: newEq = new Iron(place, 55L);
                break;
            case Radio: newEq = new Radio(place);
                break;
            case Toaster: newEq = new Toaster(place);
                break;
            case Microwave: newEq = new Microwave(place);
                break;
            case BreadMaker: newEq = new BreadMaker(place);
                break;
            case Playstation: newEq = new PlayStation(place, "PS4");
                break;
            case AirConditioning: newEq = new AirConditioning(place, "Bedroom_Cooler");
                break;
            case RobotCleaner: newEq = new RobotCleaner(place);
                break;
        }
        try {
            System.out.println("New equipment added: " + newEq.getName() + " in the " + place);
        } catch (NullPointerException e) {
            new ErrorException().timeOfError();
            System.out.println(ERRMSG + "equipment was not added, you cannot add unit of this type");
        }
        return newEq;
    }

//    private static List<Equipment> createListOfUnits() {
//        List<Equipment> smartHouse = new ArrayList<>();
//        smartHouse.add(new Fridge(Places.kitchen));
//        smartHouse.add(new PC(Places.room, "SuperPC"));
//        smartHouse.add(new PlayStation(Places.room, "PS4"));
//        smartHouse.add(new Radio(Places.bedroom));
//        smartHouse.add(new TV(15, Places.room, "SmartTV"));
//        smartHouse.add(new BreadMaker(Places.kitchen));
//        smartHouse.add(new Microwave(Places.kitchen));
//        smartHouse.add(new Toaster(Places.kitchen));
//        smartHouse.add(new AirConditioning(Places.bedroom, "Bedroom_Cooler"));
//        smartHouse.add(new Iron(Places.laundry, 55L));
//        smartHouse.add(new RobotCleaner(Places.laundry));
//        return smartHouse;
//    }


//        for (Equipment eq : smartHouse) {
//            if (eq instanceof IFoodActions) {
//                eq.turnOn();
//                String s = String.format("%1$s is turned on, it's current power is %2$o", eq.getName(), eq.getPower());
//                System.out.println(s);
//            }
//        }
//
//        System.out.println("Ok, let's bake some bread");
//        for (Equipment eq : smartHouse) {
//            if (eq instanceof BreadMaker) {
//                ((BreadMaker) eq).addFood(300);
//                ((BreadMaker) eq).startCooking();
//                ((BreadMaker) eq).foodReady();
//            }
//        }
//
}