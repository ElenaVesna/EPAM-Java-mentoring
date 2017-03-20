package com.epam.elena_bogomolova.lesson2.CleaningItems;

import com.epam.elena_bogomolova.lesson2.Supplemental.Equipment;
import com.epam.elena_bogomolova.lesson2.Supplemental.ICleaningActions;

public class Iron extends Equipment implements ICleaningActions {


    public Iron(long power, String place) {
        super(power, place);
    }

    @Override
    public void startRoomCleaning() {
        System.out.println("I cannot clean floors");
    }

    @Override
    public void startIroning() {
        System.out.println("Your clothes will be ironed soon");
    }
}
