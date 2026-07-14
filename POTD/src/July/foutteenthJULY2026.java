package July;

public class foutteenthJULY2026 {


//    class Solution {
//
//        public int gcd(int a, int b) {
//            int max = Math.max(a, b);
//            int min = Math.min(a, b);
//
//            while (a > 0 && b > 0) {
//
//                if (a > b)
//                    a = a % b;
//                else
//                    b = b % a;
//
//            }
//            if (a == 0)
//                return b;
//
//            return a;
//        }
//
//        public int solve(int[] nums, int i, int gcd1, int gcd2, int[][][] dp) {
//            if (i == nums.length) {
//                if ((gcd1 != 0) && (gcd2 != 0) && (gcd1 == gcd2)) {
//                    return 1;
//                }
//
//                return 0;
//            }
//            if (dp[i][gcd1][gcd2] != -1) {
//                return dp[i][gcd1][gcd2];
//            }
//
//            int skip = solve(nums, i + 1, gcd1, gcd2, dp);
//            int take1 = solve(nums, i + 1, gcd(gcd1, nums[i]), gcd2, dp);
//            int take2 = solve(nums, i + 1, gcd1, gcd(gcd2, nums[i]), dp);
//
//            return dp[i][gcd1][gcd2] = skip + take1 + take2;
//        }
//
//        public int subsequencePairCount(int[] nums) {
//            /// we need find the common gcd form the 2 subsequences if yoou hear the term
//            /// subsequence you must know the term ( recursion and the DP PATTERN )
//            //RECURSION GIVING  THE TLE
//            //SO WE TRY THE MEMOIZATION (DP 3D --> THREE VARIABLES ARE CHANGING)
//            /// i=> 0 --> nums.length-1..// gcd1 --> 0 --> 200( case constraints)
//            int dp[][][] = new int[nums.length +1][201][201];
//            return solve(nums, 0, 0, 0, dp);
//        }
//    }



}
