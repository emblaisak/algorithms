package org.pg4200.ex04;

public class FibonacciTest extends FibonacciTestTemplate {
    @Override
    protected IFibonacci getInstance() {
        return new Fibonacci();
    }
}
