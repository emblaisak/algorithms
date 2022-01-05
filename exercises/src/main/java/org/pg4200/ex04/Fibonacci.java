package org.pg4200.ex04;

public class Fibonacci implements IFibonacci {
    @Override
    public int compute(int n) throws IllegalArgumentException {

        if (n<0) {
            throw new IllegalArgumentException("Negative integers are not " +
                    "defined for the Fibonacci sequence");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return compute(n - 1) + compute(n - 2);
    }
}
