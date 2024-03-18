/*
 * Write a Java program to handle an ArithmeticException using try, catch, and finally block.
 * Input: Operand values for division operation mentioned in the program
 * Output: ArithmeticException caught by try-catch-finally block
 */

import java.util.Scanner;

public class handleArithmeticException {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Enter the divisor: ");
            int divisor = scanner.nextInt();
            int quotient = dividend / divisor;
            System.out.println("Quotient: " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught by try-catch-finally block");
        } finally {
            System.out.println("Finally block executed");
        }
    }
}