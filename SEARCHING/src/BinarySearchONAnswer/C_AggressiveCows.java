package BinarySearchONAnswer;

import java.util.Arrays;

public class C_AggressiveCows {


    public int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr); ///  the posoitikon of the cows sorted

        int ans = 0;
        int low = 1;
        int high = arr[arr.length - 1] - arr[0]; //
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (positions(arr, k, mid)) { ///  checking the position
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;

            }

        }
        return ans;
    }

    public boolean positions(int arr[], int k, int distance) {

        int count = 1; /// first cow at index  0
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - prev >= distance) {
                prev = arr[i];
                count++;
            }

        }

        return k <= count;
    }
}


