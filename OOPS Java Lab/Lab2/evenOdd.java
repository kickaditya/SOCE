/*
 * Accept 10 numbers from command line and check how many of them are even and how many are odd.
 *Input: Enter 10 number from keyboard
 *Output: Display number of even and odd number
 */

import java.util.Scanner;

public class evenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        int even = 0, odd = 0;
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            if (a % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        sc.close();
    }
}