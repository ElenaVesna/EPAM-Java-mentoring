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
        System.out.println("Initial array size: " + dynArray.size() + "\n");
        dynArray.remove(numToDel);
        System.out.println("Elements after deletion of the " + numToDel + "th element:");
        for (int i = 0; i < dynArray.size(); i++) {
            System.out.println(dynArray.get(i));
        }
        dynArray.elemToString(4);

        System.out.println("\n" + dynArray.get(6));

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

    public void elemToString(int i) {
    }

    public E get(int i) {
        return (E) data[i];
    }
}