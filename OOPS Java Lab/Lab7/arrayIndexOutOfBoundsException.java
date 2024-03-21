/*
 * Write a Java program to generate an ArrayIndexOutofBoundsException and handle it using catch statement.
 * Input: Enter the numbers -Example: 1 2 3 4 5 ( Suppose array size is 4 )
 * Output: Exception in thread “main”
 * java.lang.ArrayIndexOutOfBoundsException:4
 */

 import java.util.Scanner;
 public class arrayIndexOutOfBoundsException {
     public static void main(String[] args) {
         try {
             Scanner scanner = new Scanner(System.in);
             System.out.print("Enter the numbers: ");
             String input = scanner.nextLine();
             String[] numbers = input.split(" ");
             int arraySize = 4; // Suppose array size is 4

             for (int i = 0; i <= arraySize; i++) {
                 System.out.println(numbers[i]);
             }
         } catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("Exception in thread \"main\"");
             System.out.println("java.lang.ArrayIndexOutOfBoundsException: " + e.getMessage());
         }
     }
 }