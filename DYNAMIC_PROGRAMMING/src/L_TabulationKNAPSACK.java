public class L_TabulationKNAPSACK {


    public static void main(String[] args) {
        int[] val = {2, 3, 4, 5};
        int[] wt = {10, 3, 1, 3};
        int C = 10;
        int n = val.length;
        //// the i   goes to 0 -->  n-1 and the C goes to C --> 0
        int[][] dp = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < C + 1; j++) {
                dp[i][j] = -1;
            }
        }


//        System.out.println("The maximum loot " + loot(0, val, wt, C));
//        System.out.println("The maximum loot " + lootab(0, val, wt, C, dp));
    }

//    private static int lootab(int i, int[] val, int[] wt, int c, int[][] dp) {
//
//
//
//        if (i == wt.length) return 0;
//
//        int dp[i][c] =  0;
//
//        int skip = loot(i + 1, val, wt, C);
//        if (wt[i] > C) return skip;
//
//        int take = val[i] + loot(i + 1, val, wt, C - wt[i]);
//
//        return Math.max(skip, take);
//    }


}
