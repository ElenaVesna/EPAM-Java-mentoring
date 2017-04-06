package com.epam.elena_bogomolova.lesson5.task1.Supplemental;

import com.epam.elena_bogomolova.lesson3.WarningException;

public interface IFoodCooking extends IFoodActions {

    void startCooking() throws WarningException;
    boolean foodReady();
}
