package July;

import java.util.*;

public class I_twentythreee2026 {
    public int uniqueXorTriplets(int[] nums) {
        /// if eww find the triplets(i ,j  ,  k)

        /// we need to iterate the nums 3 nested loop
        /// as the brute force solution
        /// th en n^3  =  10^15 ... GIVES THE TLE
        /// after the dry run of the 1,2,3 we found that the
        /// really this converted into the " find the nearest "2^x of n""
        int n = nums.length;

        if (n == 1 || n == 2) return n;
        int ans = 1;

        while (ans <= n) {
            ans *= 2;
        }

        return ans;


    }


    public int uniqueXorTriplets2(int[] nums) {
        int n = nums.length;
        // this is the brute force solution -->
        // ITS constraint are 1500^ 3 == 10^9
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    set.add(nums[i] ^ nums[j] ^ nums[k]);/// all triplets are added but it stores the uniques only
//                }
//            }
//        }
//
//        return set.size();
//    }

        /// what will happen if we try to store first 2 number xor in the array
        /// then do the xor array elements to the one iterate
        /// its reduce the TIME COMPLEXITY FROM THE N CUBE TO N SQ + N
        HashSet<Integer> pair_xor = new HashSet<>();
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) { /// for the unique XOR operation
                pair_xor.add(nums[i] ^ nums[j]);

            }
        }
        HashSet<Integer> ans = new HashSet<>(); // the triplet pairs unique
        for (int ele : pair_xor) {
            for (int i : nums) {
                ans.add(ele ^ i);
            }
        }


        return ans.size();
    }

}
