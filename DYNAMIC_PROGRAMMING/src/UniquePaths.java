public class UniquePaths {
    /// /Top down method tha --> Memoization
    static int dp[][];

    /// recurrence relation
    public int paths_recur(int m, int n) {
        if (m == 1 || n == 1) return 1;

        return paths_recur(m, n - 1) + paths_recur(m - 1, n);
    }

    /// storing the values
    public int paths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (dp[m][n] != 0)
            return dp[m][n];

        return dp[m][n] = paths(m - 1, n) + paths(m, n - 1);
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1]; // / storing the 0  ->  m  /  n
        return paths(m, n);

    }


    /// /Bottom up method hain
    /// / Tabulation method
    public int noOfPaths(int m, int n) {
        int[][] dp = new int[m][n]; ///  tp store the repeated values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1]; //// return the answer stored in the last corner of the matrix

    }

    /// / SPACE OPTIMISATION TABULATION
    public int noOfPaths_space(int m, int n) {
        int[][] dp = new int[2][n]; ///  tp store the repeated values


        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; ////  1st row mein sab jagah hum 1 ko put karenge
        }

        dp[1][0] = 1; /// put the 1 at the starting of the 2nd row


        for (int i = 1; i <= m - 1; i++) {
            ////m-1 times means rows ko copy kre rhe na to
            ////sbse last row ko 2nd row prr lane k liye iteration should be  m  -1

            /// filling the first row
            if (i % 2 == 0) {

                for (int j = 1; j < n; j++) {
                    dp[1][j] = dp[0][j] + dp[0][j - 1];
                }

            } else {

                //// copying 1st row to 0th row

                for (int j = 1; j < n; j++) {
                    dp[0][j] = dp[1][j] + dp[1][j - 1];
                }
            }

        }


        return Math.max(dp[1][n - 1], dp[0][n - 1]); //// return the answer stored in the last corner of the matrix

    }


}
