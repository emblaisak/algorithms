package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

    /*
    If isOptimized, run a better version of bubble sort. For instance,
    elements after the last sorted element in that iteration are necessarily sorted.
    */

    public <T> int sort(T[] array, Comparator comparator, boolean isOptimized) {

        int numberOfComparisons = 0;
        boolean isSorted = false;

        do {

            if (!isOptimized) {

                boolean hasSorted = false;

                for (int i = 0; i < array.length - 1; i++) {
                    int compareResult = comparator.compare(array[i], array[i+1]);

//                If result is 0 or positive, is already sorted or equal.
                    if (compareResult > 0) {
                        T value = array[i];

                        array[i] = array[i + 1];
                        array[i + 1] = value;
                        hasSorted = true;
                    }

                    numberOfComparisons++;
                }

                if (!hasSorted) {
                    isSorted = true;
                }

            } else {

                if (array == null || array.length == 0 || array.length == 1) {
                    numberOfComparisons = 0;
                }

            }



        } while(!isSorted);

        return numberOfComparisons;
    }

}
