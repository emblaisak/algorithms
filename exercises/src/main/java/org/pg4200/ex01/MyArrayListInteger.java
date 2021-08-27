package org.pg4200.ex01;

public class MyArrayListInteger {
    private Integer[] integerList;
    private int size;

    public  MyArrayListInteger(int maxSize) {
        integerList = new Integer[maxSize];
    }

    // Call the other constructor
    public MyArrayListInteger() {
        this(10);
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index does not exist.");
            return null;
        }
        return integerList[index];
    }

    public void add(Integer value) {
        // Size-value because that number is the last index
        integerList[size] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}
