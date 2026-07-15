package July;

import java.util.*;

public class C_twelvethJuly2026 {


    public int[] arrayRankTransform(int[] arr) {

        int[] nums = Arrays.copyOf(arr, arr.length);

        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}

