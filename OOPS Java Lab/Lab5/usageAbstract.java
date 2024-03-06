/*
 * Illustrate the usage of abstract class with following Java classes –
 * An abstract class ‘student’ with two data members roll no, reg no, a method getinput() and an abstract method course()
 * A subclass ‘kiitian’ with course() method implementation
 * Write the driver class to print the all details of a kiitian object.
 * Input - Rollno - 2205180
 * Registration no - 1234567890
 * Output - Rollno: 2205180
 *          Registration no: 1234567890
 *          Course - B.Tech. (Computer Science & Engg)
 * 
 * Take user input for roll no and reg no
 */

import java.util.Scanner;

abstract class student {
    int rollNo;
    int regNo;

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll no: ");
        rollNo = sc.nextInt();
        System.out.println("Enter reg no: ");
        regNo = sc.nextInt();
    }

    public abstract void course();
}

class kiitian extends student {
    public void course() {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }
}

public class usageAbstract {
    public static void main(String[] args) {
        kiitian k = new kiitian();
        k.getInput();
        System.out.println("Roll no: " + k.rollNo);
        System.out.println("Reg no: " + k.regNo);
        k.course();
    }
}
