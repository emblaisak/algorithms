package org.pg4200.ex03;

import java.util.Comparator;

public class SortCheckerImp implements SortChecker {

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            if (a == b) {
                return 0;
            }

            if (a < b) {
                return -1;
            }

            return 1;
        }
    };

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        if (original == null && sorted == null) {
            return true;
        }

        if (original == null || sorted == null) {
            return false;
        }

        if (original.length != sorted.length) {
            return false;
        }

        if (original.length == 0 && sorted.length == 0) {
            return true;
        }

//            Check for null-values
        for (int i = 0; i < original.length; i++) {
            if (original[i] == null || sorted[i] == null) {
                return false;
            }
        }

//        Is it really sorted?
        for (int i = 0; i < sorted.length - 2; i++) {
            Integer a = (Integer) sorted[i];
            Integer b = (Integer) sorted[i + 1];

            if (comparator.compare(a, b) > 0) {
                return false;
            }
        }

//        Are they identical when both sorted?
        new OptimizedBubbleSort().sort(original, comparator, true);

        for (int i = 0; i < original.length - 1; i++) {
            if (original[i] != sorted[i]) {
                return false;
            }
        }

        return true;
    }
}
