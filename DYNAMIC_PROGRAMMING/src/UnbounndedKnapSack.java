public class UnbounndedKnapSack {


    public static void main(String[] args) {
        int[] val = {2, 3, 4, 25};
        int[] wt = {10, 3, 5, 9};
        int C = 10;
        int n = val.length;
        //// the i   goes to 0 -->  n-1 and the C goes to C --> 0
        int[][] dp = new int[n][C + 1];
        for (int  i = 0; i < n; i++) {
            for (int j = 0; j < C + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("The maximum loot " + loot(0, val, wt, C));
//        System.out.println("The maximum loot " + lootdp(0, val, wt, C, dp));
    }

    private static int loot(int i, int[] val, int[] wt, int C) {

        if (i == wt.length) return 0;

        int skip = loot(i + 1, val, wt, C);
        if (wt[i] > C) return skip;

        int take = val[i] + loot(i, val, wt, C - wt[i]); //// we can loot the anything any time

        return Math.max(skip, take);
    }


    private static int lootdp(int i, int[] val, int[] wt, int C, int[][] dp) {

        if (i == wt.length) return 0;


        //// just after the base case
        if (dp[i][C] != -1) return dp[i][C]; ////  andha dun dp lgg rha hain yaha

        int skip = lootdp(i + 1, val, wt, C, dp);
        if (wt[i] > C) return dp[i][C] = skip;/// skip the step when you get the weight is greater than Capacity
        int take = val[i] + lootdp(i + 1, val, wt, C - wt[i], dp);
        return dp[i][C] = Math.max(skip, take); /// / before giving the answer store it in the dp array
    }

}
