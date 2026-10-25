import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G_Range_FrequencyQueries {

    /// sab value ka index store karenge ek list mien vo link rahega uss vallue se
    /// in the hashmap phir jpo value ka count chaihye (usko hashmap se nikaleke )
    /// / left se just bada (index ) ko rigth ke just bada uindex mein se ghata dennge
    /// left ke just bada nikalne k liye binary search use


    private Map<Integer, List<Integer>> map;

    public G_Range_FrequencyQueries(int[] arr) {
        map = new HashMap<>();

        // Store every value's occurrence indices
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i); // use value prr -> ek aur arraylist mein value add karo
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indices = map.get(value);
        if (indices == null)
            return 0; /// not present prr ye hoga
        int first = lowerBound(indices, left);
        int afterlast = upperBound(indices, right);

        return afterlast - first;
    }

    /// binary search to search the element index just bove the val

    public int lowerBound(List<Integer> list, int target) {

        int low = 0, high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;/// id index

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid; /// just bada element ka index chaiye
            }

        }

        return low;
    }

    // First position whose value is > target
    private int upperBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}





