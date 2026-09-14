/**
 * Given an integer N, your task is to find the sum of the first N prime numbers.
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * <p>
 * Your program should efficiently calculate the sum of the first N prime numbers and print the result.
 **/

import java.util.*;

public class F_SumOf_N_Prime_Numbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Edge case: no prime numbers to sum
        if (n <= 0) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        int count = 0;
        int num = 2;

        while (count < n) {
            if (isPrime(num)) {
                sum += num;
                count++;
            }

            num++;
        }

        System.out.println(sum);
    }


    // Checks whether a number is prime
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= num / i; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}

