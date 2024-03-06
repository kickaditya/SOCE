/*
 * Find sum of each diagonal (left & right) elements separately of a user entered 3 X 3 matrix in Java.
 *Input: Enter 3X3 matrix
 *e.g. 6 7 3
 *8 9 2
 *1 2 9
 *Output: Left=24
 *Right=13
 */

import java.util.Scanner;

public class sumDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix: ");
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = sc.nextInt();
        int left = 0, right = 0;
        for (int i = 0; i < 3; i++) {
            left += arr[i][i];
            right += arr[i][2 - i];
        }
        System.out.println("Left=" + left);
        System.out.println("Right=" + right);
        sc.close();
    }
}