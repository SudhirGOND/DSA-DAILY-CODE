
import java.util.*;
//
//Use prefix sum + HashMap to count subarrays having sum k.
//Store each prefix sum in the HashMap along with its frequency.
//For every current prefix sum, check whether prefixsum - k already exists.
//If it exists, then a subarray with sum k is found, so add its frequency to total.
//Initially store 0 → 1 to handle subarrays starting from index 0.
//Finally, return total.

public class D_SubarraySumEqualsK {


    public int subarraySum(int[] arr, int k) {

        // write the intuition
        //first make the prefix array
        // made th hashmap then store the value

        HashMap<Integer, Integer> map = new HashMap<>();
        // put the pair  (o ,1)
        map.put(0, 1);
        int total = 0; // answer

        int prefixsum = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixsum += arr[i];

            if (map.containsKey(prefixsum - k))
                total += map.get(prefixsum - k);

            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        return total;
    }

}
