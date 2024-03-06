/*
 * Find the largest among 3 user entered nos. at the command prompt using Java
 * Input: Enter three number.
 *Output: Display the Largest Number
 */

import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a > b && a > c)
            System.out.println(a + " is the largest number.");
        else if (b > a && b > c)
            System.out.println(b + " is the largest number.");
        else
            System.out.println(c + " is the largest number.");
        sc.close();
    }
}