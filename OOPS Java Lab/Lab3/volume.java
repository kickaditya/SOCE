package Lab3;

/*
 * Write a class file– box with three data members(length, width, height) and a method volume() .
 * Also implement the application class Demo where an object of the box class is created with user entered dimensions and volume is printed.
 * Input: length,width and height.
 * Output: Volume
*/

import java.util.Scanner;

class box {
    private double length;
    private double width;
    private double height;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }
}

public class volume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        box b = new box();
        System.out.println("Enter the length, width and height of the box: ");
        b.setLength(sc.nextDouble());
        b.setWidth(sc.nextDouble());
        b.setHeight(sc.nextDouble());
        System.out.println("Volume of the box is: " + b.volume());
        sc.close();
    }
}

