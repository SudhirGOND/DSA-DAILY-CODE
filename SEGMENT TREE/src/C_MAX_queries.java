import java.util.Arrays;

public class C_MAX_queries {

    static int n;
    static int segtree[];


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        segtree = new int[4 * n];  // size of the segtree decided
        maxSegTree(0, 0, n - 1, arr);

        System.out.println(Arrays.toString(segtree));
        System.out.println(getMax(arr, 2, 3));
    }


    public static void maxSegTree(int i, int start, int end, int[] arr) {

        if (start == end) {
            segtree[i] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;

        maxSegTree(2 * i + 1, start, mid, arr);
        maxSegTree(2 * i + 2, mid + 1, end, arr);

        segtree[i] = Math.max(segtree[2 * i + 1], segtree[2 * i + 2]);
    }


    public static int getMax(int arr[], int left, int right) {
        int n = arr.length;
        return getUtil(0, 0, n - 1, left, right);
    }

    private static int getUtil(int i, int start, int end, int left, int right) {

        // if left se right ke bich mein segtree ka start and end nhi aya to
        // no lapping

        if (left > end || right < start) return Integer.MIN_VALUE;
        /// full overlap
        else if (start >= left && end <= right) return segtree[i];
        else { /// partial overlap
            int mid = start + (end - start) / 2;
            int leftAns = getUtil(2 * i + 1, start, mid, left, right);
            int rightAns = getUtil(2 * i + 2, mid + 1, end, left, right);
            return Math.max(leftAns, rightAns);
        }


    }

}
