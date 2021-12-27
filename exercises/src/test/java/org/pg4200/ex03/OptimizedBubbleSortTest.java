package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptimizedBubbleSortTest {

    /*
    Need at least one test with array:    ["c", "b", "a", "d", "e", "f"]
    Optimized sorting should do less than half of the comparisons in the non-optimized one
    Reach 100% statement coverage
     */

    @Test
    public void testNonOptimizedStringArray() {
        String[] actualArray = new String[]{"c", "b", "a", "d", "e", "f"};
        String[] expectedArray = new String[]{"a", "b", "c", "d", "e", "f"};

        MyStringComparator comparator = new MyStringComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        int numberOfComparisons = sorter.sort(actualArray, comparator, false);
        System.out.println("Number of comparisons are: " + numberOfComparisons);

        assertArrayEquals(expectedArray, actualArray);
        assertTrue(numberOfComparisons > 0);
    }

}
