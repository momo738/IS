package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleAreaCalculatorTest {

    @Test
    public void testCalculateRectangleArea() {
        assertEquals(12.0, RectangleAreaCalculator.calculateRectangleArea(3, 4));
    }

    @Test
    public void testCalculateRectangleAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            RectangleAreaCalculator.calculateRectangleArea(-3, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RectangleAreaCalculator.calculateRectangleArea(3, -4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RectangleAreaCalculator.calculateRectangleArea(0, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RectangleAreaCalculator.calculateRectangleArea(3, 0);
        });
    }
}
