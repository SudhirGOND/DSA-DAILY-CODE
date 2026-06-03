public class UniquePaths {

    static int dp[][];

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


}
