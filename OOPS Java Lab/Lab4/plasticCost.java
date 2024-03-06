/*
 * A Plastic manufacturer sells plastic in different shapes like 2D sheet and 3D box.
 * The cost of sheet is Rs 40/ per square ft. and the cost of box is Rs 60/ per cubic ft.
 * Implement it in Java to calculate the cost of plastic as per the dimensions given by the user where 3D inherits from 2D.
 * Input: Enter dimensions
 * Output: Display the cost of plastic
 */

import java.util.Scanner;

class TwoD {
    double length, breadth;

    TwoD(double l, double b) {
        length = l;
        breadth = b;
    }

    double area() {
        return length * breadth;
    }
}

class ThreeD extends TwoD {
    double height;

    ThreeD(double l, double b, double h) {
        super(l, b);
        height = h;
    }

    double volume() {
        return length * breadth * height;
    }
}

public class plasticCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions");
        double l = sc.nextDouble();
        double b = sc.nextDouble();
        double h = sc.nextDouble();
        sc.close();

        TwoD obj2 = new TwoD(l, b);
        ThreeD obj3 = new ThreeD(l, b, h);

        System.out.println("Cost of sheet: Rs " + obj2.area() * 40);
        System.out.println("Cost of box: Rs " + obj3.volume() * 60);
    }
}

