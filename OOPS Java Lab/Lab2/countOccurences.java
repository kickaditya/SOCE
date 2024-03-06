/*
 *Find the no. of occurrence of each element in a user entered list of nos.
 *Input: Enter list of numbers e.g.( 15 25 15 11 25 32 15 32)
 *Output: Occurrence of 15=3
 *Occurrence of 25=2
 *Occurrence of 11=1
 *Occurrence of 32=2
 */

import java.util.Scanner;

public class countOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            if (count[i] == -1)
                continue;
            int c = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    c++;
                    count[j] = -1;
                }
            }
            count[i] = c;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] != -1)
                System.out.println("Occurence of " + arr[i] + "=" + count[i]);
        }
        sc.close();
    }
}