package org.pg4200.ex04;

import org.pg4200.ex03.OptimizedBubbleSort;
import org.pg4200.les03.sort.MySort;

public class MixedSort extends OptimizedBubbleSort implements MySort{

    private final int bubbleLimit;

    public MixedSort(int bubbleLimit) {
        this.bubbleLimit = bubbleLimit;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        if (!isSorted(array)) {
            mergeSort(0, array.length - 1, array);
        }
    }

    public <T extends Comparable<T>> T[] mergeSort(int low, int high, T[] array) {
        int length = high - low + 1;

        if (length <= bubbleLimit) {
            return bubbleSort(low, high, array);
        }

        int middle = (low + high) / 2;

        // SORT LOWER HALF
        T[] lower = mergeSort(low, middle, array);

        // SORT UPPER HALF
        T[] upper = mergeSort(middle + 1, high, array);

        // MERGE
        T[] merged = merge(lower, upper);

        if (!isSorted(merged)) {
            mergeSort(0, array.length - 1, merged);
        }

        return merged;
    }

    private <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i].compareTo(array[i+1]) > 0) {
                return false;
            }
        } return true;
    }

    public <T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        int indexA = 0;
        int indexB = 0;
        int mergeIndex = 0;
        int mergeLength = array1.length + array2.length;

        T[] merge = (T[]) new Comparable[mergeLength];

        while (mergeIndex < mergeLength) {
            if (indexA > array1.length - 1) {
                while (mergeIndex < merge.length) {
                    merge[mergeIndex] = array2[indexB];
                    mergeIndex++;
                    indexB++;
                }

                return merge;
            }

            if (indexB > array2.length - 1) {
                while (mergeIndex < mergeLength) {
                    merge[mergeIndex] = array1[indexA];
                    mergeIndex++;
                    indexA++;
                }

                return merge;
            }

            int compareResult = array1[indexA].compareTo(array2[indexB]);

            if (compareResult > 0) {
                merge[mergeIndex] = array2[indexB];
                indexB++;
            } else {
                merge[mergeIndex] = array1[indexA];
                indexA++;
            }

            mergeIndex++;
        }

        return merge;
    }

    public <T extends Comparable<T>> T[] bubbleSort(int low, int high, T[] array) {
        boolean isSorted = false;
        int length = high - low + 1;

        do {
            boolean hasSorted = false;

            for (int i = low; i < high; i++) {

                int compareResult = array[i].compareTo(array[i+1]);

                if (compareResult > 0) {
                    T value = array[i];
                    array[i] = array[i+1];
                    array[i+1] = value;

                    hasSorted = true;
                }
            }

            if (!hasSorted) {
                isSorted = true;
            }

        } while (!isSorted);

        T[] sortedArray = (T[]) new Comparable[length];

        for (int i = 0; i < length; i++) {
            sortedArray[i] = array[low];
            low++;
        }

        return sortedArray;
    }
}
