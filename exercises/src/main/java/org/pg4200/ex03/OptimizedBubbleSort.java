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

//        Used if optimized, go through whole array at least once
        if (array == null){
             return 0;
        }

//        For optimized sorting
        int lastSortedIndex = array.length - 1;

        do {

            boolean hasSorted = false;

            if (!isOptimized) {

                for (int i = 0; i < array.length - 1; i++) {
                    int compareResult = comparator.compare(array[i], array[i+1]);
                    numberOfComparisons++;

//                If result is 0 or positive, is already sorted or equal.
                    if (compareResult > 0) {
                        T value = array[i];

                        array[i] = array[i + 1];
                        array[i + 1] = value;
                        hasSorted = true;
                    }
                }

            } else {
                int currentlySortedIndex = lastSortedIndex;

                for (int i = 0; i < lastSortedIndex; i++) {
                    int compareResult = comparator.compare(array[i], array[i + 1]);
                    numberOfComparisons++;

                    if (compareResult > 0) {
                        T value = array[i];

                        array[i] = array[i + 1];
                        array[i + 1] = value;
                        hasSorted = true;
                        currentlySortedIndex = i;
                    }
                }

                lastSortedIndex = currentlySortedIndex;
            }

            if (!hasSorted) {
                isSorted = true;
            }

        } while(!isSorted);

        return numberOfComparisons;
    }

}
