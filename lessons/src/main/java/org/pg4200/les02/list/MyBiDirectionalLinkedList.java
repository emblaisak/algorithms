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

        if (isValidIndex(index)) {
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

    }

//    Get node as opposed to the value
    private ListNode getNode(int index) {
        if (isValidIndex(index)) {

//            Is index in the "left" half of the list => start from head
            if(index <= size() / 2) {
                ListNode current = head;
                int counter = 0;

                while (current != null) {
                    if (counter == index) {
                        return current;
                    } else {
                        current = current.next;
                        counter++;
                    }
                }
            } else {
//            Starting from tail
                ListNode current = tail;
                int counter = size() - 1;

                while (current != null) {
                    if (counter == index) {
                        return current;
                    } else {
                        current = current.previous;
                        counter--;
                    }
                }
            }
        } else {
            throw new NullPointerException("Index is valid - node not found");
        }

        return null;
    }

    private boolean isValidIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return true;
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(int index, T value) {

        if (isValidIndex(index)) {
            ListNode node = new ListNode();
            node.value = value;

//            Now the node is created and its value stored. Now to decide what index it should receive.

            if (head == null) {
//                List is empty
                head = tail = node;
            } else if (index == 0) {

                // Head's previous is assign to the new node, node's next is assign to head and new head is node
                head.previous = node;
                node.next = head;
                head = node;

            } else if (index == size) {

                tail.next = node;
                node.previous = tail;
                tail = node;

            } else {

//                The list is not empty, and requested index is not head or tail
                ListNode target = getNode(index);
                ListNode beforeTarget = target.previous;

                beforeTarget.next = node;
                node.previous = beforeTarget;

//                Move the node on the requested index to the right
                node.next = target;
                target.previous = node;
            }

            size++;

        }

    }

    @Override
    public int size() {
        return size;
    }
}
