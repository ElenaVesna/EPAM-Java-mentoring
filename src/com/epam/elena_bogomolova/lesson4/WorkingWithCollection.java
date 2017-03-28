package com.epam.elena_bogomolova.lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WorkingWithCollection {

    public static void main(String[] args) {

        int numOfElements = 10;

        ArrayList<Integer> array = createRandomizedArray(numOfElements);
        for (Integer anArray1 : array) { System.out.println(anArray1); }
//        isOrderRandom(array);
//        areAllElementsUnique(array);

        findSmallestElement(array);
        findSecondSmallElem(array);

//        findSecondSmallElemId(array);
//        deleteOddElements(array);

//        deleteElementsOnOddPlaces(array);
    }

    private static int findSecondSmallElem(ArrayList<Integer> array) {
        int smallest = findMinElementId(array);
        int elNSmall = array.get(smallest);
        for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < smallest && !array.get(i).equals(elNSmall)) {
                    elNSmall = array.get(i);
                }

            }
        System.out.printf("\n The second smallest element is: %o \n", elNSmall);
        return elNSmall;

    }

    private static void findSmallestElement(ArrayList<Integer> array) {
        System.out.println("The smallest element is:");
        int smId = findMinElementId(array);
        System.out.printf("%1$o (on the %2$o-th place) \n", array.get(smId), smId + 1);
    }


    private static void deleteOddElements(ArrayList<Integer> array) {
//        check for small amount of elements
//        System.out.println("before");
//        for (Integer anArray1 : array) { System.out.println(anArray1); }
        array.removeIf(e -> e.equals(e/2*2 + 1));
//        check for small amount of elements
//        System.out.println("after");
//        for (Integer anArray : array) { System.out.println(anArray); }
        System.out.println("\n\n After deleting odd elements:");
        System.out.println("new array size = " + array.size());

    }

    private static void deleteElementsOnOddPlaces(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("last element before deleting odd: " + array.get(array.size() - 1));
        for (int i = 0; i < array.size(); i++) {
            array.subList(i, i + 1).clear();
        }
        System.out.println("size after deleting odd elements: " + array.size());
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("last element after deleting odd: " + array.get(array.size() - 1));
    }

    private static int findMinElementId(ArrayList<Integer> array) {
        int minElement = Integer.MAX_VALUE;
        int placeOfMinElem = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < minElement) {
                minElement = array.get(i);
                placeOfMinElem = i;
            }
        }
       return placeOfMinElem;

    }

    private static boolean areAllElementsUnique(ArrayList<Integer> array) {
        Set uniqSet = new HashSet<>(array);
        if (uniqSet.size() == array.size()) {
            System.out.println("All elements are unique \n");
            return true;
        } else {
            System.out.println("Array has repeating elements");
            return false;
        }
    }

    private static ArrayList<Integer> createRandomizedArray(int numOfElements) {
        ArrayList<Integer> array = new ArrayList();
        for (int i = 2; i < numOfElements + 2; i++) {
            array.add(i);
        }
        Collections.shuffle(array);
        return array;
    }

    private static boolean isOrderRandom(ArrayList<Integer> array) {
        int numOfEnlarge = 0;
        int numOfDecrease = 0;
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) < array.get(1 + i)) {
                numOfEnlarge ++;
            } else numOfDecrease ++;
        }
        int dif = Math.abs(numOfEnlarge - numOfDecrease);
        if (dif < array.size()/2) {
            System.out.println("Array elements are randomized");
            return true;
        } else  {
            System.out.println("Array is not randomized good enough");
            return false;
        }
    }
}
