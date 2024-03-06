/*
Aim of the program -Write a program to print your name, roll no, section and
branch in separate lines.
Input: Mention Name,Roll no,Section and branch
Output: Display Name
Display Roll No
Display Section
Display Branch
Take user input
*/

import java.util.Scanner;

public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter your roll no");
        int rollno=sc.nextInt();
        System.out.println("Enter your section");
        String section=sc.next();
        System.out.println("Enter your branch");
        String branch=sc.next();
        System.out.println("Name: "+name);
        System.out.println("Roll No: "+rollno);
        System.out.println("Section: "+section);
        System.out.println("Branch: "+branch);
    }
}

