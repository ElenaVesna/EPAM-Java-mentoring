package com.epam.elena_bogomolova.lesson5.task1;

import com.epam.elena_bogomolova.lesson5.task1.EntertainmentItems.*;
import com.epam.elena_bogomolova.lesson5.task1.KitchenItems.*;
import com.epam.elena_bogomolova.lesson5.task1.OtherItems.*;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.*;
import com.epam.elena_bogomolova.lesson5.task1.Supplemental.Interfaces.*;

import java.io.*;

public class Serialization {

    private static final String ERRMSG = "---Error message: ";

    public static void main(String[] args) throws WarningException, IOException, ClassNotFoundException {

        Equipment myTV = createUnit(Units.TV, Places.room);
        myTV.turnOn();
        ((VideoItem)myTV).playVideo();
//        current param
        System.out.println("------TV now has the following parameters (power, place, state): ");
        System.out.println(myTV.getPower());
        System.out.println(myTV.getPlace());
        System.out.println(myTV.isIdle());
//        сериализация объекта
        saveUnitState(myTV);
        restoreSavedState(myTV);
        myTV.move();
        ((VideoItem) myTV).stopVideo();
//        new param withing the program
        System.out.println("-------New TV parameters (power, place, state): ");
        System.out.println(myTV.getPower());        System.out.println(myTV.getPlace());        System.out.println(myTV.isIdle());
//        десериализация
//        System.out.println("------saved TV parameters (power, place, state):");
        Equipment tvSavedState = restoreSavedState(myTV);

//        System.out.println(tvSavedState.getPower());        System.out.println(tvSavedState.getPlace());        System.out.println(tvSavedState.isIdle());
    }

    private static Equipment restoreSavedState(Equipment unit) throws IOException, ClassNotFoundException {
        FileInputStream tempIn = new FileInputStream("temp-" + unit.getName() + ".out");
        ObjectInputStream out = new ObjectInputStream(tempIn);
        Equipment savedTV = (Equipment)out.readObject();
        System.out.println("---param from serialized object");
        System.out.println(savedTV.getPower());
        System.out.println(savedTV.getPlace());
        System.out.println(savedTV.isIdle());
        return savedTV;
    }

    private static void saveUnitState(Equipment unit) throws IOException {
        FileOutputStream tempFile = new FileOutputStream("temp-" + unit.getName() + ".out");
        ObjectOutputStream out = new ObjectOutputStream(tempFile);
        out.writeObject(unit);
        out.flush();
        out.close();
    }

    private static void xmsSave(Equipment unit) {

    }

    private static Equipment createUnit(Units unitType, Places place) {
        Equipment newEq = null;
        switch (unitType) {
            case Fridge: newEq = new Fridge(place) {
            };
                break;
            case PC: newEq = new PC(place, "SuperPC");
                break;
            case TV: newEq = new TV("SmartTV");
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
}
