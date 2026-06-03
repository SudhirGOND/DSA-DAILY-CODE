import java.util.*;

public class MINCOSTCLIMBING {


    static int dp[];

    public int minPay(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int take = minPay(cost, i + 2);
        int jump = minPay(cost, i + 1);

        int ans = cost[i] + Math.min(take, jump);
        dp[i] = ans;
        return ans;

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n]; // 0 to n-1
        Arrays.fill(dp, -1); // mark
        return Math.min(minPay(cost, 0), minPay(cost, 1));
    }

}
