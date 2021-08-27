package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils {
    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int min = array[0];
        System.out.println(min);

        for (int i : array
             ) {
            if (i < min) {
               min = i;
            }
        }

        return min;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);
        int max = array[0];

        for (int i : array
             ) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkArray(array);
        double sum = 0;
        double mean;

        for (int i : array
             ) {
            sum += i;
        }

        mean = sum / array.length;

        return mean;
    }

    private void checkArray(int[] array) throws IllegalArgumentException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
