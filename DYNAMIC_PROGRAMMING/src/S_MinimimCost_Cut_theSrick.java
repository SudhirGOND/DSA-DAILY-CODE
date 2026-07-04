import java.util.Arrays;

public class S_MinimimCost_Cut_theSrick {


    public static void main(String[] args) {
        int cuts[] = {5, 6, 1, 2, 4};
        System.out.println(minCost(5, cuts));


    }

    public static int minCost(int n, int cuts[]) {


        int[] arr = new int[cuts.length + 2];
        /// we put all the elements ans --> 0 and n at  last index
        int i;
        for (i = 0; i < cuts.length; i++) {
            arr[i] = cuts[i];

        }

        arr[i++] = 0;
        arr[i] = n;

        /// then we sort

        Arrays.sort(arr);
        int m = arr.length;
        /// here we made the dp
        // i  -->  1  to n-2 takk   n-2-> 1 (j)
        int dp[][] = new int[m - 1][m - 1];

        for (i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return cost(1, m - 2, arr, dp);

    }

    private static int cost(int i, int j, int[] arr, int dp[][]) {

        if (i > j) return 0; /// after this yoou can't be  able to cut the stick
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int length = arr[j + 1] - arr[i - 1];
            int totalcost = cost(i, k - 1, arr, dp) + cost(k + 1, j, arr, dp) + length;
            min = Math.min(min, totalcost);
        }


        return dp[i][j] = min;
    }


    /// / the tabulation of the code MINCOST of the cutting the STICK
    public int minCosttab(int n, int[] cuts) {

        int[] arr = new int[cuts.length + 2];

        /// we put all the elements and --> 0 and n

        arr[0] = 0;

        int i;
        for (i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }

        arr[cuts.length + 1] = n;

        /// then we sort

        Arrays.sort(arr);

        int m = arr.length;

        /// here we made the dp
        // i --> 1 to m-2
        // j --> 1 to m-2

        int dp[][] = new int[m][m];

        for (i = m - 2; i >= 1; i--) {

            for (int j = 1; j <= m - 2; j++) {

                if (i > j) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;

                //// every time we get the minimum new total cost

                for (int k = i; k <= j; k++) {

                    int length = arr[j + 1] - arr[i - 1];

                    int totalcost = dp[i][k - 1] + dp[k + 1][j] + length;

                    min = Math.min(min, totalcost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m - 2];
    }


}
