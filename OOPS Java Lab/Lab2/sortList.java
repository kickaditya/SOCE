/*
 * Program to sort the user entered list of numbers of any size
 *Input: List of Numbers
 *Output: Display the numbers in Ascending order
 */

import java.util.Scanner;

public class sortList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i], minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
        System.out.println("The sorted list is: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        sc.close();
    }
}