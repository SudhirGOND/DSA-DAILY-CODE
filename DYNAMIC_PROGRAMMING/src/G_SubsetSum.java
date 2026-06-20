public class G_SubsetSum {


    public static void main(String[] args) {
        int[] arr = {23, 10, 2, 3};
        int target = 15;

//        System.out.println(subsum(0, arr, target));
        //// target -->  0 and the i  == >  0 -->  n
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(subsumdp(0, arr, target, dp));
    }

    /// this is the code of the recursion
    private static boolean subsum(int i, int[] arr, int target) {

        if (i == arr.length) {
            return target == 0;
        }

        boolean skip = subsum(i + 1, arr, target);


        if (target - arr[i] < 0)
            return skip; /// only valid for the +ve numbers
        boolean take = subsum(i + 1, arr, target - arr[i]);
        return take || skip; ////  taking the OR of these twoss

    }


    /// doing it by the memoization
    private static boolean subsumdp(int i, int[] arr, int target, int dp[][]) {

        if (i == arr.length) {
            return target == 0;
        }

        if (dp[i][target] != -1) return dp[i][target] == 1; /// already visited
        boolean ans = false;

        boolean skip = subsumdp(i + 1, arr, target, dp);

        if (target - arr[i] < 0) ans = skip;/// marked that visited
        else {
            boolean pick = subsumdp(i + 1, arr, target - arr[i], dp);
            ans = pick || skip;
        }

        dp[i][target] = ans ? 1 : 0;
        return ans;

    }

}
