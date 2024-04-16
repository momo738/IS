package org.example;

public class TriangleAreaCalculator {

    public static double calculateTriangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive numbers");
        }
        return (base * height) / 2;
    }

    public static void printTriangleArea(double base, double height) {
        double area = calculateTriangleArea(base, height);
        System.out.println("The area of the triangle is: " + area);
    }
}


