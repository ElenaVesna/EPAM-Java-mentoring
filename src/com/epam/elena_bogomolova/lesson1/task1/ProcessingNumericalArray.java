package com.epam.elena_bogomolova.lesson1.task1;

import java.util.*;
import java.util.function.IntPredicate;

public class ProcessingNumericalArray extends ArrayBasicActions {

    private int arrayLength = 19;
    private int minElement = -10;
    private int maxElement = 10;

    public static void main(String[] args) {
        ProcessingNumericalArray app = new ProcessingNumericalArray();
        app.startProcessingArray();
    }

    private void startProcessingArray() {
//        task 1.1
        switchPlacesMaxMinusMinPlus();
//        task 1.2
        countEvenElements();
//        task 1.3
        replaceElementsLessThanSpecifiedByNumber(0, 0);
//        task 1.3 - second variant
        replaceElementsByNumberLambda((g) -> (g < 0), 0);
//        task 1.4
        multiplyPositiveAfterNegative(3);
//        task 1.5
        differenceMinAverage();
//        task 1.6
        oddRepeatingElements();
    }


    //     task 1.1
    private void switchPlacesMaxMinusMinPlus() {
        int[] myArray = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        int maxMinus = myArray[0];
        int positionMaxMinus = 0;
        int minPlus = myArray[0];
        int positionMinPlus = 0;
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] < 0 && myArray[i] > maxMinus) {
                maxMinus = myArray[i];
                positionMaxMinus = i;
            }
            if (myArray[i] > 0 && myArray[i] < minPlus) {
                minPlus = myArray[i];
                positionMinPlus = i;
            }
        }
        if (maxMinus < 0 && minPlus > 0) {
            myArray[positionMaxMinus] = minPlus;
            myArray[positionMinPlus] = maxMinus;
            System.out.println("minimum positive and maximum negative switched places");
            printArrayElements(myArray);
        } else {
            System.out.println("cannot switch places: no suitable elements");
        }

    }

    //     task 1.2
    private void countEvenElements() {
        int[] myArray = new ArrayBasicActions().createArray(20, -10, 10);
        int sumEvenElem = 0;
        for (int i = 1; i < myArray.length; i += 2) {
            sumEvenElem += myArray[i];
        }
        System.out.println("Sum of even elements: " + sumEvenElem);
    }

    //    task 1.3
    private void replaceElementsLessThanSpecifiedByNumber(int specifiedNumber, int replacingNumber) {
        int[] myArray = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        System.out.println("\n array without negative elements:");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < specifiedNumber) {
                myArray[i] = replacingNumber;
            }
        }
        printArrayElements(myArray);
    }

    //    task 1.3 - second variant
    private void replaceElementsByNumberLambda(IntPredicate predicate, int replacingNumber) {
        int[] myArray = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        System.out.println("\n array without negative elements:");
        for (int i = 0; i < myArray.length; i++) {
            if (predicate.test(myArray[i])) {
                myArray[i] = replacingNumber;
            }
        }
        printArrayElements(myArray);
    }

    //    task 1.4
    private void multiplyPositiveAfterNegative(int multiplier) {
        int[] array = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < 0 && array[i + 1] > 0) {
                array[i + 1] *= multiplier;
            }
        }
        System.out.println("every positive element multiplied by 3, if it goes after the negative element");
        printArrayElements(array);
    }

    //    task 1.5
    private void differenceMinAverage() {
        int[] array = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        int minimum = array[0];
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        float average = (float) sum / array.length;
        System.out.println("minimum element in array: " + minimum + ", average: " + average);
        System.out.println("their difference: " + Math.abs((average - minimum)));
    }

    //    task 1.6
    private void oddRepeatingElements() {
        int[] array = new ArrayBasicActions().createArray(arrayLength, minElement, maxElement);
        int halfLength = (int) array.length / 2;
        int[] oddElements = new int[arrayLength / 2];
        for (int i = 0; i < halfLength; i++) {
            oddElements[i] = array[2 * i + 1];
        }
        ArrayList<Integer> repeatingElements = new ArrayList<>();
        for (int i = 1; i < oddElements.length; i++) {
            int element = oddElements[i];
            for (int j = 0; j < i; j++) {
                if (element == oddElements[j]) {
                    repeatingElements.add(element);
                }
            }
        }
        HashSet<Integer> uniqElements = new HashSet<>(repeatingElements);
        System.out.println("Repeating elements on odd places:");
        System.out.println(uniqElements);
    }
}