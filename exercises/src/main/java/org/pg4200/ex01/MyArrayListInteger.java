package org.pg4200.ex01;

public class MyArrayListInteger {
    private Integer[] integerData;
    // Actual used size
    private int size;

    public MyArrayListInteger(int maxSize) {
        integerData = new Integer[maxSize];
    }

    // Call the other constructor with size 10 if not specified
    public MyArrayListInteger() {
        this(10);
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index does not exist.");
            return null;
        }
        return integerData[index];
    }

    public void add(Integer value) {
        // Size-value because that number is the last index
        integerData[size] = value;
        size++;
    }

    public int size() {
        return size;
    }
}
