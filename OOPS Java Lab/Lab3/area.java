package Lab3;

/*
 * Write a program which will overload the area () method and display the area of a circle, triangle and square as per user choice and user entered dimensions.
 * Input: Mention dimensions like radius, base, height, side
 * Output: Display area of circle
 * Display area of triangle
 * Display area of square
 */

import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the shape for which you want to calculate the area: ");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Square");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the radius of the circle: ");
                double radius = sc.nextDouble();
                calculateCircleArea(radius);
                break;
            case 2:
                System.out.println("Enter the base of the triangle: ");
                double base = sc.nextDouble();
                System.out.println("Enter the height of the triangle: ");
                double height = sc.nextDouble();
                calculateTriangleArea(base, height);
                break;
            case 3:
                System.out.println("Enter the side of the square: ");
                double side = sc.nextDouble();
                calculateSquareArea(side);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void calculateCircleArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle is: " + area);
    }

    public static void calculateTriangleArea(double base, double height) {
        double area = 0.5 * base * height;
        System.out.println("Area of the triangle is: " + area);
    }

    public static void calculateSquareArea(double side) {
        double area = side * side;
        System.out.println("Area of the square is: " + area);
    }
}