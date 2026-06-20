
import java.util.Arrays;

public class K_TargetSumDP {
    public static void main(String[] args) {


        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;

//        System.out.println(ways(0, arr, target));

        int total_sum = 0;
        int n = arr.length;
        for (int i : arr) {
            total_sum += i;
        }
        int[][] dp = new int[n][2 * total_sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }


        System.out.println(waysdp(0, 0, total_sum, arr, target, dp));
    }

    private static int waysdp(int i, int sum, int total_sum, int[] arr, int target, int[][] dp) {


        if (i == arr.length)
            if (target == sum) return 1;
            else return 0;

        /// to access the index of the dp[col] = sum + (total+sum)
        if (dp[i][sum + total_sum] != -1) return dp[i][sum + total_sum];

        int pick = waysdp(i + 1, sum + arr[i], total_sum, arr, target, dp);
        int skip = waysdp(i + 1, sum - arr[i], total_sum, arr, target, dp);

        return dp[i][sum + total_sum] = pick + skip; //// sum +  total sum--> for the better indexing
    }

    /// solving the problem through recursion

    private static int ways(int i, int[] arr, int target) {

        if (i == arr.length)
            if (target == 0)
                return 1;
            else return 0;

        int pick = ways(i + 1, arr, target - arr[i]); ///  including the +
        int skip = ways(i + 1, arr, target + arr[i]); ////  including the -


        return pick + skip; ////  total number of ways

    }


}
