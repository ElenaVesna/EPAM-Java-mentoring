package com.epam.elena_bogomolova.lesson4;

public class DynamicArray<E> {

    private Object[] data = new Object[2];
    private int arraySize = 0;

    public static void main(String[] args) {
        int numToDel = 5;
        int initArraySize = 10;
        DynamicArray<String> dynArray = new DynamicArray<>();
        for (int i = 0; i < initArraySize; i++) {
            dynArray.add("Element-" + i);
        }
        System.out.printf("Initial array size: %d \n", dynArray.size());
        dynArray.remove(numToDel);
        System.out.printf("Elements after deletion of the %d-th element: \n", numToDel);
        for (int i = 0; i < dynArray.size(); i++) {
            System.out.println(dynArray.get(i));
        }
        dynArray.elemToString();

        System.out.println();
        System.out.println(dynArray.get(6));

    }

    public int size() {
        return arraySize;
    }

    public void remove(int i) {
        Object[] current = data;
        for (int j = 0; j < current.length - 1; j++) {
            if (j < i) {
                data[j] = current[j];
            } else if (j >= i) {
                data[j] = current[j+1];
            }
        }
        arraySize--;
    }

    public void add(E newElement) {
        if (data.length <= arraySize) {
            Object[] current = data;
            data = new Object[arraySize*2];
            System.arraycopy(current, 0, data, 0, current.length);
        }
        data[arraySize] = newElement.toString();
        arraySize++;
    }

    public void elemToString() {
        System.out.printf("\nNow array contains of %d elements \n", size());
    }

    public E get(int i) {
        System.out.printf("The %d-th element: ", i);
        return (E) data[i];
    }
}