/*
 * Illustrate the execution of constructors in multi-level inheritance with three Java classes – plate(length, width), box(length, width, height), wood box (length, width, height, thick) where box inherits from plate and woodbox inherits from box class.
 * Each class has constructor where dimensions are taken from user.
 * Input: Enter the dimensions
 * Output: Display the dimensions accordingly
 */

import java.util.Scanner;

class Plate {
    double length, width;

    Plate(double l, double w) {
        length = l;
        width = w;
    }
}

class Box extends
        Plate {
    double height;

    Box(double l, double w, double h) {
        super(l, w);
        height = h;
    }
}

class WoodBox extends
        Box {
    double thickness;

    WoodBox(double l, double w, double h, double t) {
        super(l, w, h);
        thickness = t;
    }
}

public class multilevelInheritence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions");
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        double t = sc.nextDouble();
        sc.close();

        Plate obj1 = new Plate(l, w);
        Box obj2 = new Box(l, w, h);
        WoodBox obj3 = new WoodBox(l, w, h, t);

        System.out.println("Plate: " + obj1.length + "x" + obj1.width);
        System.out.println("Box: " + obj2.length + "x" + obj2.width + "x" + obj2.height);
        System.out.println("Wood Box: " + obj3.length + "x" + obj3.width + "x" + obj3.height + "x" + obj3.thickness);
    }
}

