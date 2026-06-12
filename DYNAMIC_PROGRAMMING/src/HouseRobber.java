import java.util.Arrays;

public class HouseRobber {
    /// edge case -> adjacent gharsse no chori allowed i to i + 2 ////i + 1
    // for dp two changes --> changes ko record krr lo
    static int[] dp;

    public int loot(int[] nums, int i) {
        if (i >= nums.length)
            return 0; /// array se aage jaoge to ghar khali hain 1st line
        if (dp[i] != -1)
            return dp[i];
        int pick = nums[i] + loot(nums, i + 2); /// 2 ghar chodke lootna
        int skip = loot(nums, i + 1);/// skippin the bagal walqa ghar
        int ans = Math.max(pick, skip);
        dp[i] = ans; /// before the answering store the value for the further use
        return ans;
    }


    /// try to do the using the tabulation
    ///
    public int rob2(int[] arr) {
        int n = arr.length;

        // Create a dp array to store the maximum loot at each house
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = arr[0];

        // Fill the dp array using the bottom-up approach
        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(arr[i - 1] + dp[i - 2], dp[i - 1]);

        return dp[n];
    }


    /// / by the space optimized solution we have the following code


    public int rob_space(int[] arr) {
        int sp[] = new int[3];
        int n = arr.length;
        sp[1] = arr[0];
        for (int i = 2; i <= n; i++) {
            sp[2] = Math.max(arr[i] + sp[0], sp[1]);

            //// space optimizing using the 3 size array

            sp[0] = sp[1];
            sp[1] = sp[2];
        }

        return sp[2];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);/// filled with the -1 /// marking
        return loot(nums, 0); //// 0 index gharse lootna start


    }

}
