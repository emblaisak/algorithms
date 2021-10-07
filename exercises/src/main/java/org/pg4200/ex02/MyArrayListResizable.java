package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    @Override
    public void add(int index, T value) {

        if(index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (size == data.length) {
            Object[] biggerData = new Object[size * 2];

            for(int i = 0; i < data.length; i++) {
                biggerData[i] = data[i];
            }

            data = biggerData;

            super.add(index, value);
        }

    }
}
