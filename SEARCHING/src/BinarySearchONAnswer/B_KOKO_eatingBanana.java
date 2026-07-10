package BinarySearchONAnswer;

public class B_KOKO_eatingBanana {

    /// nums as the array of the banana stack
    public int minEatingSpeed(int[] nums, int hours) {/// min speed will be 1 max will mw max from the each stack

        long max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele); /// maximum speed
        }

        long low = 1, high = max, ans = max;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (hour(mid, nums) <= hours) {

                high = mid - 1;
                ans = mid;

            }

            else {
                low = mid + 1;

            }
        }

        return (int)ans;
    }

    public long hour(long speed, int nums[]) {

        long ans = 0;
        for (int ele : nums) {
            if (ele % speed == 0)
                ans += ele / speed;

            else {
                ans += ele / speed + 1;
            }
        }

        return ans;

    }


}
