/*
 * Write a class Account containing acc_no, balance as data members and two methods as input() for taking input from user and disp() method to display the details.
 * Create a subclass Person which has name and aadhar_no as extra data members and override disp() function.
 * Write the complete program to take and print details of three persons.
 * Input: Enter details of three persons.
 * Output: Display details of three persons.
 */

 import java.util.Scanner;

 class Account {
     protected String acc_no;
     protected double balance;

     public void input() {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Enter account number: ");
         this.acc_no = scanner.nextLine();

         System.out.println("Enter balance: ");
         this.balance = scanner.nextDouble();
     }

     public void disp() {
         System.out.println("Account Number: " + this.acc_no);
         System.out.println("Balance: " + this.balance);
     }
 }

 class Person extends Account {
     private String name;
     private String aadhar_no;

     @Override
     public void input() {
         super.input();

         Scanner scanner = new Scanner(System.in);

         System.out.println("Enter name: ");
         this.name = scanner.nextLine();

         System.out.println("Enter Aadhar number: ");
         this.aadhar_no = scanner.nextLine();
     }

     @Override
     public void disp() {
         super.disp();

         System.out.println("Name: " + this.name);
         System.out.println("Aadhar Number: " + this.aadhar_no);
     }
 }

 public class personDetails {
     public static void main(String[] args) {
         Person[] persons = new Person[3];

         for (int i = 0; i < 3; i++) {
             persons[i] = new Person();
             System.out.println("Enter details for person " + (i + 1) + ":");
             persons[i].input();
         }

         for (int i = 0; i < 3; i++) {
             System.out.println("\nDetails for person " + (i + 1) + ":");
             persons[i].disp();
         }
     }
 }