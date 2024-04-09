package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateTriangleArea() {
        assertEquals(6.0, TriangleAreaCalculator.calculateTriangleArea(3, 4));
    }

    @Test
    public void testCalculateTriangleAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateTriangleArea(-3, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateTriangleArea(3, -4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateTriangleArea(0, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateTriangleArea(3, 0);
        });
    }

    @Test
    public void testPrintTriangleArea() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TriangleAreaCalculator.printTriangleArea(3, 4);
        assertEquals("The area of the triangle is: 6.0\n", outContent.toString());
    }
}

