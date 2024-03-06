/*
 * Write a program in Java to create a class Rectangle having data members length and breadth and three methods called read,
 * calculate and display to read the values of length and breadth, calculate the area and perimeter of the rectangle and display the result respectively.
 * Input: Mention length and breadth
 * Output: Display Area of Rectangle and Perimeter of rectangle.
 */
import java.util.Scanner;

class Rectangle {
    private double length;
    private double breadth;

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length: ");
        this.length = scanner.nextDouble();

        System.out.println("Enter breadth: ");
        this.breadth = scanner.nextDouble();
    }

    public double calculateArea() {
        return this.length * this.breadth;
    }

    public double calculatePerimeter() {
        return 2 * (this.length + this.breadth);
    }

    public void display() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

public class rectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.read();
        rectangle.display();
    }
}
