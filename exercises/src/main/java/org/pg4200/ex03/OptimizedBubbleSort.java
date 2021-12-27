package org.pg4200.ex03;

import org.pg4200.ex03.Comparator;

public class OptimizedBubbleSort {
    public <T> int sort(T[] array, Comparator comparator, boolean isOptimized) {

//        If isOptimized, run a better version of bubble sort. For instance,
//        the elements after the last sorted element is necessarily sorted.

        for (int i = 0; i < array.length; i++ ) {
            boolean isSorted = comparator.compare(array[i], array[i+1]);
        }

        //        Return the number of times the comparator is called.
        return 3;
    }
}
