/**
 * Q1. You are given two integers, n1 and n2. Your task is to find the
 * n1_th and n2_th prime numbers, compute their product, and then
 * subtract 1 from the result.
 * <p>
 * Input : 4 5  ( 2 ,3 ,5 ,7 ,11.....)(  7  *  11 ==  77  -1  == 76)(below dekho)
 * Output :76
 **/


import java.util.*;
public class K_Nth_PrimeNumber {

    static boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();


        int max = Math.max(n1, n2);

        int count = 0;
        int number = 2;

        int a = 0;
        int b = 0;

        while (count < max) {

            if (isPrime(number)) {

                count++;

                if (count == n1) {
                    a = number;
                }

                if (count == n2) {
                    b = number;
                }
            }

            number++;
        }

        System.out.println(a * b - 1);
    }
}


//public class K_Nth_PrimeNumber {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int n1 = sc.nextInt();
//        int n2 = sc.nextInt();
//
//        int maxN = Math.max(n1, n2);
//
//        // Approximate upper bound for nth prime
//        int limit;
//
//        if (maxN < 6) {
//            limit = 15;
//        } else {
//            limit = (int) (maxN * (Math.log(maxN) + Math.log(Math.log(maxN)))) + 10;
//        }
//
//        boolean[] isPrime = new boolean[limit + 1];
//
//        Arrays.fill(isPrime, true);
//
//        isPrime[0] = false;
//        isPrime[1] = false;
//
//        // Sieve
//        for (int i = 2; i * i <= limit; i++) {
//
//            if (isPrime[i]) {
//
//                for (int j = i * i; j <= limit; j += i) {
//                    isPrime[j] = false;
//                }
//            }
//        }
//
//        int count = 0;
//        int prime1 = 0;
//        int prime2 = 0;
//
//        for (int i = 2; i <= limit; i++) {
//
//            if (isPrime[i]) {
//
//                count++;
//
//                if (count == n1) {
//                    prime1 = i;
//                }
//
//                if (count == n2) {
//                    prime2 = i;
//                }
//
//                if (prime1 != 0 && prime2 != 0) {
//                    break;
//                }
//            }
//        }
//
//        long answer = (long) prime1 * prime2 - 1;
//
//        System.out.println(answer);
//    }
//}
