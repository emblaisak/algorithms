package org.pg4200.ex04;

import java.util.ArrayList;

public class FibonacciMemoized implements IFibonacci {

    private Integer[] sequence = new Integer[100];

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if (n < 0) {
            throw new IllegalArgumentException("Negative integers are not " +
                    "defined for the Fibonacci sequence");
        }

        /*
        Expand the array when necessary
         */
        if (n > (sequence.length - 1)) {
            Integer[] newArray = new Integer[n + 1];

            for (int i = 0; i < sequence.length; i++) {
                newArray[i] = sequence[i];
            }

            newArray[n] = null;

            sequence = newArray;
        }

        if (n < sequence.length && sequence[n] != null) {
            return sequence[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int result = compute(n - 1) + compute(n - 2);

        if (result < sequence.length) {
            sequence[n] = result;
        }

        return result;
    }
}
