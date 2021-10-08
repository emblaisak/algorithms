package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;
    int head = -1;
    int tail = -1;

    public MyRingArrayQueue() {
        this(10);
    }
    public MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }

//    ADD DATA TO THE TAIL
    @Override
    public void enqueue(T value) {

//        IS IT EMPTY?
        if (isEmpty()) {
            head = tail = 0;
//        IS THE QUEUE NOT A RING?
        } else if (head <= tail) {
            // IS THERE FREE SPACE IN THE END OF QUEUE?
            if (tail < data.length -1) {
                tail++;
            // THERE IS NO IMMEDIATELY AVAILABLE SPACE
            } else {
                // IS THERE SPACE FOR THE QUEUE TO WRAP IN A RING? => TAIL WRAPS TO 0
                if(head > 0) {
                    tail = 0;
                // THE INTERNAL ARRAY IS FULL
                } else {
                    Object[] bigger = new Object[data.length * 2];

                    for (int i = 0; i < data.length; i++) {
                        bigger[i] = data[i];
                    }

                    data = bigger;
                    // NOW THERE IS SPACE, CAN MOVE TAIL UP
                    tail++;
                }
            }
//        THE QUEUE IS A RING
        } else {
            // IS THERE STILL FREE SPACE IN THE RING?
            if (tail < head - 1) {
                tail++;
            } else {
                // THERE IS NO FREE SPACE - CREATE NEW INTERNAL ARRAY
                Object[] bigger = new Object[data.length * 2];

                // MOVE TO NEW ARRAY FROM OLD HEAD, BEFORE WRAP
                int k = 0;
                for (int i = head; i < data.length; i++) {
                    bigger[k] = data[i];
                    k++;
                }

                // MOVE WRAPPED VALUES TO NEW ARRAY
                k = bigger.length - 1;
                for (int i = 0; i < head; i++) {
                    bigger[k] = data[i];
                }

                data = bigger;
                head = 0;
                tail = data.length - 1;

                data[tail] = value;

            }
        }
    }

//    REMOVES DATA FROM HEAD, MOVES HEAD-INDEX AND RETURNS DELETED OBJECT
    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new RuntimeException();
        }

        // Store value to be deleted
        T value = (T) data[head];

        // IF SIZE IS 1, THEN QUEUE SHOULD NOW BE EMPTY
        if(size() == 1) {
            head = tail = -1;
        } else {
            data[head] = null;
            head++;
        }

        return value;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {

        if (head < 0) {
            return 0;
        } else {
            return tail - head + 1;
        }

    }
}
