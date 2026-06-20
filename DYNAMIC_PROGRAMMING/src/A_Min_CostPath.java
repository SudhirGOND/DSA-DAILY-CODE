public class A_Min_CostPath {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            /// while traversing in between the grids
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j]; /// coner uppper answer

                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];/// first row mein prefix sum input krr rhe

                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j]; /// fill the 1st column prefix sum
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }

        }

        return dp[m - 1][n - 1];  //// the last corner
    }


}
