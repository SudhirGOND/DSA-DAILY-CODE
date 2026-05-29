import java.util.Arrays;
import java.util.HashSet;

class IntersectionOFArrays {
    public int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>(); /// holds only the unique values
        int min = Math.min(arr1.length, arr2.length);
        int ans[] = new int[min];
        int idx = 0;
        for (int ele : arr1) {
            set.add(ele);

        }

        //// now check that it contains the element
        for (int ele : arr2) {
            if (set.contains(ele)) {
                ans[idx++] = ele;
                set.remove(ele); //// this line remove the duplicate ele after insertion
            }
        }

        return Arrays.copyOf(ans,idx); ////  return only the elements size min hain... jitne bhare hain 

    }
}