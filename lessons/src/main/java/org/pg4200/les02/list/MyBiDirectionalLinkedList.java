package org.pg4200.les02.list;

import java.util.List;

public class MyBiDirectionalLinkedList<T> implements MyList<T> {

//    Value is stored in Node-object with reference to previous and next element
    private class ListNode {
        T value;
        ListNode previous;
        ListNode next;
}

    @Override
    public void delete(int index) {

    }

    @Override
    public boolean isEmpty() {
        return MyList.super.isEmpty();
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T value) {
        MyList.super.add(value);
    }

    @Override
    public void add(int index, Object value) {

    }

    @Override
    public int size() {
        return 0;
    }
}
