package org.pg4200.ex04;

public class FibonacciMemoizedTest extends FibonacciTestTemplate {
    @Override
    protected IFibonacci getInstance() {
        return new FibonacciMemoized();
    }
}
