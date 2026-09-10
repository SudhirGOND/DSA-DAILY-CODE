/**
 * Time limit: 1.00 s
 * Memory limit: 512 MB
 * <p>
 * You are given all numbers between 1,2,.....,n except one. Your task is to find the missing number.
 * Input
 * The first input line contains an integer n.
 * The second line contains n-1 numbers. Each number is distinct and between 1 and n (inclusive).
 * Output
 * Print the missing number.
 * Constraints
 * <p>
 * 2 \le n \le 2 \cdot 10^5
 * <p>
 * Example
 * Input:
 * 5
 * 2 3 1 5
 * <p>
 * Output:
 * 4
 **/


import java.util.*;

public class B_MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = n;

        for (int i = 1; i < n; i++) {
            ans ^= i;
            ans ^= sc.nextInt();
        }

        System.out.println(ans);
    }
}

