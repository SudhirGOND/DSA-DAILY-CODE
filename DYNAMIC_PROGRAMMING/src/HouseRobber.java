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

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);/// filled with the -1 /// marking
        return loot(nums, 0); //// 0 index gharse lootna start


    }

}
