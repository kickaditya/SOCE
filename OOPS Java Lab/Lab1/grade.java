/*
Aim of the program: Write a program to print the corresponding grade for the
given mark using if..else statement in Java
Input: Mention the grade in the program
Output: Display the Grade either O/E/A/B/C
Take user input
*/

import java.util.Scanner;

public class grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your mark");
        int mark=sc.nextInt();
        if(mark>=90)
        {
            System.out.println("Grade O");
        }
        else if(mark>=80)
        {
            System.out.println("Grade E");
        }
        else if(mark>=70)
        {
            System.out.println("Grade A");
        }
        else if(mark>=60)
        {
            System.out.println("Grade B");
        }
        else if(mark>=50)
        {
            System.out.println("Grade C");
        }
        else
        {
            System.out.println("Fail");
        }
    }
}