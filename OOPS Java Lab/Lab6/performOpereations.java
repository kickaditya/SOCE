/*
 * Write a program to perform following operations on user entered strings and a character –
 * i) Change the case of the string
 * ii) Reverse the string
 * iii) Compare two strings
 * iv) Insert one string into another string
 * v) Convert the string to upper case and lower case
 * vi) Check whether the character is present in the string and at which position
 * vii) Check whether the string is palindrome or not.
 * viii) Check the number of word, vowel and consonant in the string
 * Input: Enter a String : amit
 * Output: The string after changing the case is AMIT
 * The string after reversing is tima
 * Input: Enter the second string for comparision : kumar
 * Output: The difference between ASCII value is 10
 * Input: Enter the string to be inserted into first string : thakur
 * Output: The string after insertion is : amit thakur
 * Enter a String : Amit
 * Output: Uppercase: AMIT
 * Lowercase: amit
 * Input: Enter a String :Amitkumar
 * Enter a character : m
 * Output: Position of entered character: 2
 * Input: Enter a String : Amitkumar
 * Enter a character : Y
 * Output: Entered character is not present
 * Input: Enter a String : madam
 * Output: Entered string is palindrome
 * Input: Enter a String : muscle
 * Output: Entered string is not a palindrome
 * Input: Enter a String : Ram is going to school
 * Output: No. of words: 5
 * No. of vowels: 7
 * No. of consonants: 11
 */

import java.util.Scanner;

public class performOpereations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.nextLine();
        System.out.println("The string after changing the case is " + str.toUpperCase());
        System.out.println("The string after reversing is " + new StringBuilder(str).reverse().toString());
        System.out.println("Enter the second string for comparision : ");
        String str2 = sc.nextLine();
        System.out.println("The difference between ASCII value is " + (str.compareTo(str2)));
        System.out.println("Enter the string to be inserted into first string : ");
        String str3 = sc.nextLine();
        System.out.println("The string after insertion is : " + str + " " + str3);
        System.out.println("Enter a String : ");
        str = sc.nextLine();
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Enter a String : ");
        str = sc.nextLine();
        System.out.println("Enter a character : ");
        char ch = sc.next().charAt(0);
        if (str.indexOf(ch) != -1) {
            System.out.println("Position of entered character: " + (str.indexOf(ch) + 1));
        } else {
            System.out.println("Entered character is not present");
        }
        System.out.println("Enter a String : ");
        str = sc.nextLine();
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            System.out.println("Entered string is palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }
        System.out.println("Enter a String : ");
        str = sc.nextLine();
        int words = 0, vowels = 0, consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                words++;
            } else if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
                    || str.charAt(i) == 'O' || str.charAt(i) == 'U') {
                vowels++;
            } else {
                consonants++;
            }
        }
        words++;
        System.out.println("No. of words: " + words);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);
    }
}