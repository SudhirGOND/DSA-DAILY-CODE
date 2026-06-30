public class Q_Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int dp[] = new int[n];
        int max = 0;//// the max length upon all subsequence
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) { //// count of the less ele

                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}

