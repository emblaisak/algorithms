package org.pg4200.ex01;

import org.junit.jupiter.api.Test;
import org.pg4200.ex01.TriangleClassification.Classification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.pg4200.ex01.TriangleClassification.Classification.*;
import static org.pg4200.ex01.TriangleClassification.classify;

public class TriangleClassificationTest {

    @Test
    public void testNotTriangle() {
        Classification notATriangle1 = classify(0,2,5);
        assertEquals(NOT_A_TRIANGLE, notATriangle1);

        Classification notATriangle2 = classify(100,2,5);
        assertEquals(NOT_A_TRIANGLE, notATriangle2);
    }

    @Test
    public void testEquilateral() {
        Classification equilateral = classify(40,40,40);
        assertEquals(EQUILATERAL, equilateral);

        Classification notEquilateral = classify(5, 9, 5);
        assertNotEquals(EQUILATERAL, notEquilateral);
    }

    @Test
    public void testIsosceles() {
        Classification isosceles = classify(5, 5, 3);
        assertEquals(ISOSCELES, isosceles);
    }

    @Test
    public void testScalene() {
        Classification scalene = classify(5,3,4);
        assertEquals(SCALENE, scalene);
    }
}
