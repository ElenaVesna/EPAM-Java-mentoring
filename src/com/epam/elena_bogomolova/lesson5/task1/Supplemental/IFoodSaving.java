package com.epam.elena_bogomolova.lesson5.task1.Supplemental;

public interface IFoodSaving extends IFoodActions {
    void startFreezing(int temperature);
    boolean foodFrozen(int temperature);
}
