package com.epam.elena_bogomolova.lesson1.task1;


import java.lang.reflect.Array;

public class ArrayBasicActions {
    public int[] createArray(int length, int minElement, int maxElement) {
        System.out.println("initial array with " + length + " integer numbers:");
        int[] myArray = new int[length];
//        generate data
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (minElement + Math.random()*(maxElement - minElement + 1));
        }
        printArrayElements(myArray);
        return myArray;
    }

    public void printArrayElements(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(i + " element: " + myArray[i]);
        }
        System.out.println();
    }
}
