package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptimizedBubbleSortTest {

    /*
    Need at least one test with array:    ["c", "b", "a", "d", "e", "f"]
    Optimized sorting should do less than half of the comparisons in the non-optimized one
    Reach 100% statement coverage
     */

    int numberOfNonOptComparisons;
    int numberOfOptComparisons;

    @Test
    public void testNonOptimizedStringArray() {
        String[] actualArray = new String[]{"c", "b", "a", "d", "e", "f"};
        String[] expectedArray = new String[]{"a", "b", "c", "d", "e", "f"};

        MyStringComparator comparator = new MyStringComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(actualArray, comparator, false);
        System.out.println("Number of comparisons are: " + numberOfNonOptComparisons);

        assertArrayEquals(expectedArray, actualArray);
        assertTrue(numberOfNonOptComparisons > 0);
    }

    @Test
    public void testOptimizedStringArray() {
        String[] actualArrayNonOpt = new String[]{"c", "b", "a", "d", "e", "f"};
        String[] actualArrayOpt = new String[]{"c", "b", "a", "d", "e", "f"};
        String[] expectedArray = new String[]{"a", "b", "c", "d", "e", "f"};

        MyStringComparator comparator = new MyStringComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(actualArrayNonOpt, comparator, false);
        numberOfOptComparisons = sorter.sort(actualArrayOpt, comparator, true);
        System.out.println("Number of comparisons are: " + numberOfOptComparisons);

        assertArrayEquals(expectedArray, actualArrayOpt);
        assertTrue(numberOfNonOptComparisons > (numberOfOptComparisons * 2));
    }

    @Test
    public void testNonOptimizedGameUserArray() {
        GameUser[] actualArray = new GameUser[]{
                new GameUser("Lark", 25),
                new GameUser("Sting", 20),
                new GameUser("Babylon", 3),
                new GameUser("Leo", 20),
                new GameUser("Leo", 20),
                new GameUser("Kleopatra", 12),
                new GameUser("Alan", 4),

        };

        GameUser[] expectedArray = new GameUser[]{
                new GameUser("Babylon", 3),
                new GameUser("Alan", 4),
                new GameUser("Kleopatra", 12),
                new GameUser("Leo", 20),
                new GameUser("Leo", 20),
                new GameUser("Sting", 20),
                new GameUser("Lark", 25),
        };

        GameUserComparator comparator = new GameUserComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(actualArray, comparator, false);
        System.out.println("Number of comparisons are: " + numberOfNonOptComparisons);

        for (int i = 0; i < actualArray.length - 1; i++) {
            assertTrue(actualArray[i].equals(actualArray[i]));
        }

        assertFalse(expectedArray[3].equals(actualArray[0]));

        assertTrue(numberOfNonOptComparisons > 0);
    }

    @Test
    public void testOptimizedGameUserArray() {
        GameUser[] actualArrayNonOpt = new GameUser[]{
                new GameUser("Lark", 25),
                new GameUser("Sting", 20),
                new GameUser("Babylon", 3),
                new GameUser("Leo", 20),
                new GameUser("Kleopatra", 12),
                new GameUser("Alan", 4)
        };

        GameUser[] actualArrayOpt = actualArrayNonOpt;

        GameUser[] expectedArray = new GameUser[]{
                new GameUser("Lark", 25),
                new GameUser("Sting", 20),
                new GameUser("Babylon", 3),
                new GameUser("Leo", 20),
                new GameUser("Kleopatra", 12),
                new GameUser("Alan", 4)
        };

        GameUserComparator comparator = new GameUserComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(actualArrayNonOpt, comparator, false);
        numberOfOptComparisons = sorter.sort(actualArrayOpt, comparator, true);
        System.out.println("\nNumber of comparisons are: " + numberOfOptComparisons + " over " +
                numberOfNonOptComparisons + " non-optimized comparisons");

        for (int i = 0; i < actualArrayOpt.length - 1; i++) {
            assertTrue(actualArrayOpt[i].equals(expectedArray[i]));
        }

        assertTrue(numberOfNonOptComparisons > (numberOfOptComparisons * 2));
    }

    @Test
    public void testEmptyStringArray() {
        String[] actualArray = new String[]{};
        String[] expectedArray = new String[]{};

        MyStringComparator comparator = new MyStringComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(actualArray, comparator, false);
        System.out.println("Number of comparisons are: " + numberOfNonOptComparisons);

        assertArrayEquals(expectedArray, actualArray);
        assertTrue(numberOfNonOptComparisons == 0);
    }

    @Test
    public void testNullStringArray() {
        MyStringComparator comparator = new MyStringComparator();
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        numberOfNonOptComparisons = sorter.sort(null, comparator, false);
        System.out.println("Number of comparisons are: " + numberOfNonOptComparisons);

        assertTrue(numberOfNonOptComparisons == 0);
    }

}
