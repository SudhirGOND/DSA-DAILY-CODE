import java.util.Arrays;

// This is Used for the Update the Range Queries Repeatedly

public class E_MaximumQuery_Update_Lazy_Propagation_Subarray_Sum {

    static int n;
    static int segtree[];
    static int lazy[];

    public static void main(String[] args) {

        int arr[] = {2, 3, 4, 5, 6, -1, 5, 9, 10, -19};


        int[][] queries = {{1, 4, 3}, {2, 3, 4}, {4, 9, 10}, {3, 8, -2}};

        n = arr.length;

        segtree = new int[4 * n];
        lazy = new int[4 * n];

        // Build Segment Tree
        buildSegTree(0, 0, n - 1, arr);

        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.println("Original Sum   : " + getSum(0, n - 1));

        // Range Update Queries
        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];

            updateRange(0, 0, n - 1, left, right, val);

            System.out.println("\nAfter Update " + (i + 1) + " :");
            System.out.println("Range : [" + left + ", " + right + "]");
            System.out.println("Value : " + val);
            System.out.println("Sum   : " + getSum(left, right));
        }

        // Get Final Array
        for (int i = 0; i < n; i++) {
            arr[i] = getSum(i, i);
        }

        System.out.println("\nFinal Array : " + Arrays.toString(arr));
        System.out.println("Final Sum   : " + getSum(0, n - 1));
    }


    // ================= BUILD =================

    public static void buildSegTree(int i, int start, int end, int arr[]) {

        if (start == end) {
            segtree[i] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        buildSegTree(2 * i + 1, start, mid, arr);
        buildSegTree(2 * i + 2, mid + 1, end, arr);

        segtree[i] = segtree[2 * i + 1] + segtree[2 * i + 2];
    }


    // ================= LAZY PROPAGATION =================

    public static void pushDown(int i, int start, int end) {

        if (lazy[i] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        int val = lazy[i];

        // Update Left Child
        segtree[leftChild] += (mid - start + 1) * val;
        lazy[leftChild] += val;

        // Update Right Child
        segtree[rightChild] += (end - mid) * val;
        lazy[rightChild] += val;

        // Clear Pending Update
        lazy[i] = 0;
    }


    // ================= RANGE UPDATE =================

    public static void updateRange(int i, int start, int end, int left, int right, int val) {

        // No Overlap
        if (left > end || right < start) {
            return;
        }

        // Full Overlap
        if (start >= left && end <= right) {

            segtree[i] += (end - start + 1) * val;
            lazy[i] += val;

            return;
        }

        // Partial Overlap
        pushDown(i, start, end);

        int mid = start + (end - start) / 2;

        updateRange(2 * i + 1, start, mid, left, right, val);

        updateRange(2 * i + 2, mid + 1, end, left, right, val);

        // Recalculate Current Node
        segtree[i] = segtree[2 * i + 1] + segtree[2 * i + 2];
    }


    // ================= SUM QUERY =================

    public static int getSum(int left, int right) {

        return getUtil(0, 0, n - 1, left, right);
    }

//     the  th e,ain commncept of the segment tree to find the segment

    public static int getUtil(int i, int start, int end, int left, int right) {

        // No Overlap
        if (left > end || right < start) {
            return 0;
        }

        // Full Overlap
        if (start >= left && end <= right) {
            return segtree[i];
        }

        // Partial Overlap
        pushDown(i, start, end);

        int mid = start + (end - start) / 2;

        int leftAns = getUtil(2 * i + 1, start, mid, left, right);

        int rightAns = getUtil(2 * i + 2, mid + 1, end, left, right);

        return leftAns + rightAns;
    }
}