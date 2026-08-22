import java.util.*;

public class C_ZeroSumSubarray {


    public boolean subArrayExists(int arr[]) {
        /// brute force akroge to O(n^3) ->  O(n^2)

        /// Now we observe that it place we need the prefix sum

        int prefixsum[] = new int[arr.length];

        prefixsum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixsum[i] = arr[i] + prefixsum[i - 1];

        }

        HashSet<Integer> set = new HashSet<>();

        for (int i : prefixsum) {

            if (i == 0) return true; /// prefix um mein zero ho to  return true ;

            if (set.contains(i))
                return true;
            set.add(i);
        }

        return false;

    }


    /// / we can do the code boooelan code withouut  the us of the prefix sum array
    // we need only to prefixsum variable



}
