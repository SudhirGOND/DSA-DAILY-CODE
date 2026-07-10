package BinarySearchONAnswer;

public class A_CapacityToShipPackages {

    public static int lengthWeightCapacity(int arr[], int n, int d) {


        int max = Integer.MIN_VALUE, sum = 0;
        for (int ele : arr) {
            max = Math.max(max, ele); /// mminimum capacity ( ship)
            sum += ele; /// etna maximum capacity (ship)
        }

        int low = max, high = sum, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (days(mid, arr) <= d) {
                high = mid - 1;
                ans = mid;
            } else low = mid + 1;
        }
        return ans;
    }

    private static int days(int capacity, int[] arr) {

        int days = 0;
        int c = capacity; /// capacity of the ship

        for (int ele : arr) {
            if (c >= ele) c -= ele;
            else {
                days++;
                c = capacity - ele;
            }
        }
        days++;

        return days;
    }


}


