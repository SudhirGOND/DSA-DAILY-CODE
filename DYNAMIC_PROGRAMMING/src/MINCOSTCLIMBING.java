import java.util.*;

public class MINCOSTCLIMBING {


    static int dp[];

    public int minPay(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int take = minPay(cost, i + 2);
        int jump = minPay(cost, i + 1); ////// House_robber(step->totally skipped) but in this(add the i+1 cost also)

        int ans = cost[i] + Math.min(take, jump);
        dp[i] = ans;
        return ans;

    }

    /// tabulation of this
    public int minpay(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];

        dp[0] = cost[0];/// dp ke first index prr 1 element dalenge
        dp[1] = cost[1];/// dp ke second place per 2 element
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]); //// last 2 mien se sbse kamm + curr cost
        }

        return Math.min(dp[n - 1], dp[n - 2]);/// last 2 mein se sbse kamm ans
    }


    /// space optimized
    ///
    public static int mincost_space_optimized(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n]; // 0 to n-1
        Arrays.fill(dp, -1); // mark
        return Math.min(minPay(cost, 0), minPay(cost, 1));
    }

}
