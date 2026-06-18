public class COINCHANGE {

    public long coinCount(int i, int coins[], int amount) {
        if (i == coins.length) {
            if (amount == 0)
                return 0; //// no more needed
            else
                return Integer.MAX_VALUE; /// not a valid combination
        }

        long skip = coinCount(i + 1, coins, amount);

        if (amount - coins[i] < 0)
            return skip;
        long pick = 1 + coinCount(i, coins, amount - coins[i]);/// we have the unlimited coins // unbounded dp

        return Math.min(skip, pick);
    }

    public int coinChange(int[] coins, int amount) {


        int ans = (int) coinCount(0, coins, amount);

        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }


    /// /// doing the code inthe memoization method --> tc  will be O(coinslength * amount )
    public int coinChangedp(int[] coins, int amount) {

        long[][] dp = new long[coins.length][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int) coinCountdp(0, coins, amount,dp);

        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }

    public long coinCountdp(int i, int coins[], int amount, long dp[][]) {
        if (i == coins.length) {
            if (amount == 0)
                return 0; //// no more needed
            else
                return Integer.MAX_VALUE; /// not a valid combination
        }

        if (dp[i][amount] != -1) return dp[i][amount];

        long skip = coinCount(i + 1, coins, amount);

        if (amount - coins[i] < 0)
            return dp[i][amount] = skip;
        long pick = 1 + coinCount(i, coins, amount - coins[i]);/// we have the unlimited coins // unbounded dp

        return dp[i][amount] = Math.min(skip, pick);
    }

}
