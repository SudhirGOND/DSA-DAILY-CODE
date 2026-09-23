/**
 * Understanding the Problem Statement
 * Inputs:
 * <p>
 * N: Length of the NUM array.
 * <p>
 * X: Lower bound of the valid range.
 * <p>
 * Y: Upper bound of the valid range.
 * <p>
 * NUM: Array of numbers.
 * <p>
 * Operations:
 * <p>
 * Form pairs (NUM[i], NUM[j]).
 * <p>
 * Concatenate them (like 5 and 5 becomes 55).
 * <p>
 * Check if X <= Concatenated Number <= Y.
 * <p>
 * Count how many such valid pairs exist.
 * N= 4
 * NUM = [5, 15, 1, 9]
 * X=10 RANGE
 * Y= 99
 * Pairs & Concatenations:
 * <p>
 * Answer 3 -< Valid pairs
 * i<  j -->  Condition
 *
 */

public class J_Array_Simulation {
    public static void main(String[] args) {

        int arr[] = {5, 15, 1, 9};
        int x = 10, y = 99;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                String s = "" + arr[i] + arr[j]; /// main logic is this

                int num = Integer.parseInt(s);

                if (num >= x && num <= y) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
