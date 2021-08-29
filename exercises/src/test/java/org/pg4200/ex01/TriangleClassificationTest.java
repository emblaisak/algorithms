package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TriangleClassificationTest {

    @Test
    public void testNotTriangle() {
        assertEquals(TriangleClassification.classify(0,2,5),
                TriangleClassification.Classification.NOT_A_TRIANGLE);

        assertEquals(TriangleClassification.classify(100,3,3),
                TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    public void testEquilateral() {
        assertEquals(TriangleClassification.classify(2,2,2),
                TriangleClassification.Classification.EQUILATERAL);
        assertNotEquals(TriangleClassification.classify(5,9,12),
                TriangleClassification.Classification.EQUILATERAL);
    }

    @Test
    public void testIsosceles() {
        assertEquals(TriangleClassification.classify(5, 5, 3),
                TriangleClassification.Classification.ISOSCELES);
    }

    @Test
    public void testScalene() {
        assertEquals(TriangleClassification.classify(5,3,4),
                TriangleClassification.Classification.SCALENE);
    }
}
