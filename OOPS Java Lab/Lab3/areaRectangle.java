
/*
 * Write a program in java using constructor overloading concept to calculate the area of a rectangle having data member as length and breadth.
 * Use default constructor to initialize the value of the data member to zero and parameterized constructor to initialize the value of data member according to the user input.
 * Input: Mention the value of length and breadth
 * Output: Display the area of rectangle accordingly.
 */

import java.util.Scanner;

public class areaRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle: ");
        double length = sc.nextDouble();
        System.out.println("Enter the breadth of the rectangle: ");
        double breadth = sc.nextDouble();
        Rectangle r = new Rectangle(length, breadth);
        r.calculateArea();
    }
}

class Rectangle {
    double length;
    double breadth;

    public Rectangle() {
        length = 0;
        breadth = 0;
    }

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of the rectangle is: " + area);
    }
}

