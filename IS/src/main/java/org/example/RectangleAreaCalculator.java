package org.example;

public class RectangleAreaCalculator {

    public static double calculateRectangleArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive numbers");
        }
        return length * width;
    }
}