import java.util.Arrays;

public class R_Matrix_Chain_Multiplication {

    public static void main(String[] args) {
//        int arr[][] = {{1, 2}, {2, 3}, {3, 4}};


        int[] arr = {1, 2, 3, 4};

//        int n = arr.length;
        /// 2 varibles  are changing so dp  =--> 2d
        //// i  -->  0 to n-2 ==  k +1
//        /// j  -->  n-2   to 0
//        int dp[][] = new int[n - 1][n - 1];
//
//        for (int i = 0; i < n - 1; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(mincost(0, n - 2, arr, dp));

        System.out.println(mincosttabu(arr));
    }

    /// // the tabulation method of solving this
    private static int mincosttabu(int[] arr) {


        int n = arr.length;
        int dp[][] = new int[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= n - 2; j++) {
                /// the base case
                if (i >= j) {
                    dp[i][j] = 0;
                    continue;
                }

                int minCost = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int mulCost = arr[i] * arr[k + 1] * arr[j + 1];
                    int total = dp[i][k] + dp[k + 1][j] + mulCost;

                    minCost = Math.min(minCost, mulCost);

                }

                dp[i][j] = minCost;
            }

        }
        return dp[0][n - 2]; // the cost at the last index


    }

//    public static int mincost(int i, int j, int arr[], int[][] dp) {
//
//
//        if (i == j) return 0;
//
//        if(dp[i][j] !=  -1) return dp[i][j];
//
//        int Mincost = Integer.MAX_VALUE;
//
//        for (int k = i; k < j; k++) {
//            int multicost = arr[i] * arr[j + 1] * arr[k + 1];
//            int totalcost = multicost + mincost(i, k, arr,dp) + mincost(k + 1, j, arr,dp);
//
//            Mincost = Math.min(Mincost, totalcost);
//        }
//
//        return dp[i][j] = Mincost;
//    }
    /// the recursive code of the Matrix Multiplication ( min cost )
//    public static int mincost(int i, int j, int arr []) {
//
//
//        if (i == j) return 0;
//        int Mincost = Integer.MAX_VALUE;
//
//        for (int k = i; k < j; k++) {
//            int multicost = arr[i][0] * arr[j][1] * arr[k][1];
//            int totalcost = multicost + mincost(i, k, arr) + mincost(k + 1, j, arr);
//
//            Mincost = Math.min(Mincost, totalcost);
//        }
//
//        return Mincost;
//    }


}
