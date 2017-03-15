package com.epam.elena_bogomolova.lesson2.Supplemental;


public interface IFoodActions {
    boolean checkForFood();
    void setTemperature(int degree);

    void addFood(int foodWeight);
    void removeFood (int foodWeight);

}
