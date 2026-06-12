public class Fibonacci {

    ///  0   1    1   2  3   5    8   13    21 ....

    static int dp[];

    /// / to store the value we need the an 1d array
//    public static int fibo(int n) {
//
//        if (n <= 1) return n;
//        if (dp[n] != 0) return dp[n];
//
//        return dp[n] = fibo(n - 1) + fibo(n - 2);
//
//    }

    /// / using the tabulation method

//
//    public static int fibo2(int n) {
//
//
//        if (n <= 1) return n;
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[n];
//    }
    public static void main(String[] args) {
        int n = 6;
//        dp = new int[n + 1]; /// the size of the dp will be the n +1
        dp = new int[3]; ////  only 3 for the space optimized
        System.out.println(fibo2(n));


    }

    private static int fibo2(int n) {
        if (n <= 1) return n;

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }

}
