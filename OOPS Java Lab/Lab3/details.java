package Lab3;

/*
 * Write a program in java to input and display the details of n number of students having roll, name and cgpa as data members. 
 * Also display the name of the student having lowest cgpa.
 * Input: Enter Roll No, Name and cgpa of ‘n’ number of students.
 * Output: Display the details of ‘n’ number of students. Also display the name of student with lowest cgpa
 */

import java.util.Scanner;

class student {
    private int roll;
    private String name;
    private double cgpa;

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void display() {
        System.out.println("Roll No: " + roll);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class details {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        student[] s = new student[n];
        for (int i = 0; i < n; i++) {
            s[i] = new student();
            System.out.println("Enter the roll, name and cgpa of student " + (i + 1) + ": ");
            s[i].setRoll(sc.nextInt());
            sc.nextLine();
            s[i].setName(sc.nextLine());
            s[i].setCgpa(sc.nextDouble());
        }
        System.out.println("Details of students: ");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
        double min = s[0].getCgpa();
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (s[i].getCgpa() < min) {
                min = s[i].getCgpa();
                index = i;
            }
        }
        System.out.println("Student with lowest cgpa: ");
        s[index].display();
        sc.close();
    }
}

