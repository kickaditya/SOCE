/*
 * Aim of the program : Write a program in Java to take first name and last name from user and print both in one line as last name followed by first name.

 *Input: Enter first name: KIIT
 *Enter Second Name: UNIVERSITY
 *Output: UNIVERSITY KIIT
 */

import java.util.Scanner;

public class printName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name");
        String fname=sc.nextLine();
        System.out.println("Enter your last name");
        String lname=sc.nextLine();
        System.out.println(lname+" "+fname);
    }
}