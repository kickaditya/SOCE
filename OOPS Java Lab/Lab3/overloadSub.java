
/*
 * Write a program to overload subtract method with various parameters in a class in Java. Write the driver class to use the different subtract methods using object.
 * Input: Mention various subtract method having different parameters.
 * Output: Subtract method will display the result accordingly
 */

public class overloadSub {
    public static void main(String[] args) {
        overloadSub os = new overloadSub();
        System.out.println("Subtracting 5 from 10: " + os.subtract(10, 5));
        System.out.println("Subtracting 5.5 from 10.5: " + os.subtract(10.5, 5.5));
        System.out.println("Subtracting 5 from 10 from 15: " + os.subtract(15, 10, 5));
        System.out.println("Subtracting 5.5 from 10.5 from 15.5: " + os.subtract(15.5, 10.5, 5.5));
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int subtract(int a, int b, int c) {
        return a - b - c;
    }

    public double subtract(double a, double b, double c) {
        return a - b - c;
    }
}

