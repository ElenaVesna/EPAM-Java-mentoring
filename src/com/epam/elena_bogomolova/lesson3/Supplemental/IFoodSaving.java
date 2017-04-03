package com.epam.elena_bogomolova.lesson3.Supplemental;

public interface IFoodSaving extends IFoodActions {
    void startFreezing(int temperature);
    boolean foodFrozen(int temperature);
}
