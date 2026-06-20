public class H_PartitionOfSubsetSUM {


    private boolean subsumdp(int i, int[] arr, int target, int dp[][]) {

        if (i == arr.length) {
            return target == 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target] == 1; /// Already visited
        boolean ans = false;

        boolean skip = subsumdp(i + 1, arr, target, dp);

        if (target - arr[i] < 0)
            ans = skip;/// Marked that visited
        else {
            boolean pick = subsumdp(i + 1, arr, target - arr[i], dp);
            ans = pick || skip;
        }

        dp[i][target] = ans ? 1 : 0;
        return ans;

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 == 1)
            return false; /// For the Odd Sum

        /// Now for the even sum then it is Divided into two equal matrices

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return subsumdp(0, nums, target, dp);

    }


}
