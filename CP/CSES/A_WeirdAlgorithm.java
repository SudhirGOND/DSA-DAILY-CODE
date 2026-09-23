/**
 * Consider an algorithm that takes as input a positive integer n. If n is even, the algorithm divides it by two, and if n is odd, the algorithm multiplies it by three and adds one. The algorithm repeats this, until n is one. For example, the sequence for n=3 is as follows:
 * $$ 3 \rightarrow 10 \rightarrow 5 \rightarrow 16 \rightarrow 8 \rightarrow 4 \rightarrow 2 \rightarrow 1$$
 * Your task is to simulate the execution of the algorithm for a given value of n.
 * Input
 * The only input line contains an integer n.
 * Output
 * Print a line that contains all values of n during the algorithm.
 * Constraints
 * <p>
 * 1 \le n \le 10^6
 * <p>
 * Example
 * Input:
 * 3
 * <p>
 * Output:
 * 3 10 5 16 8 4 2 1
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_WeirdAlgorithm {


    public static void main(String[] args) throws IOException {
//  This is not Efficient code as  this code what it takes to be!!
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.print(n + " ");
//        while (n != 1) {
//            System.out.print(n + " ");
//            if (n % 2 == 0) n /= 2;
//            else {
//                n *= 3;
//                n++;
//            }

//
//        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n != 1) {
            sb.append(n).append(" ");
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }

        sb.append(1);//  at the end last mein  1 lga do

        System.out.println(sb);
    }

    /// Time:  O(k)
    /// Space: O(k)


}
