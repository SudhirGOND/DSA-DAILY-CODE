public class Fibonacci {

    ///  0   1    1   2  3   5    8   13    21 ....

    static int dp[];

    /// / to store the value we need the an 1d array
    public static int fibo(int n) {

        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];

        return dp[n] = fibo(n - 1) + fibo(n - 2);

    }


    public static void main(String[] args) {
        int n = 10;
        dp = new int[n + 1]; /// the size of the dp willbe the n +1
        System.out.println(fibo(n));


    }

}
