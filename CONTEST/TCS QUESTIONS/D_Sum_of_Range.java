

/**
 * You are given two integers
 * <p>
 * i and j.
 * Your task is to calculate and print the sum of all integers from
 * i to j, inclusive.
 **/

/// sum(i -> j)

import java.util.Scanner;

public class D_Sum_of_Range {

    /// /  1 <= i , j  <= 9999
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number :");
        int i = sc.nextInt();
        System.out.println("Enter the second Number :");
        int j = sc.nextInt();
        /*
        1.. i >  j se bada ho to error
        2.. i < 0 ho ya j >= 10000 se to error
        3..
         */
        if (i >= j || i < 0 || j >= 10000) {
            System.out.println("Invalid Input ");
        } else {

            System.out.println(sumrange(i, j));
        }


    }

    public static int sumrange(int i, int j) {
        int n = (j - i + 1);
        int ans  =  (n)*(i + j);
        return ans/2;
    }
}
