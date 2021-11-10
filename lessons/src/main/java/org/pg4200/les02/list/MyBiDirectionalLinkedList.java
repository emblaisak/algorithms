package org.pg4200.les02.list;

public class MyBiDirectionalLinkedList<T> implements MyList<T> {

    private class ListNode {
        T value;
        ListNode previous;
        ListNode next;
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    @Override
    public void delete(int index) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

//        Is this the first node?
        if (index == 0) {
            // Move head to the right if there is a node
            if (head.next != null) {
                head = head.next;
                head.previous = null;
            } else {
                head = tail = null;
            }
//            Is this the last node?
        } else if (index == (size - 1)) {
            tail = tail.previous;
            tail.next = null;
//            In the last case, we're not working on the head or tail anymore. We need a getNode-method.
        } else {
            ListNode target = getNode(index);
            // Target node is now equal to the next node? I have no idea what happens here.
            target.previous.next = target.next;
            target.next.previous = target.previous;
        }

        size--;

    }

    private ListNode getNode(int index) {
        return new ListNode();
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
