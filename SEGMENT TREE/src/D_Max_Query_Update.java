import java.util.Arrays;

public class D_Max_Query_Update {

    public static void main(String[] args) {

        int[] arr = {2, 4, -1, 3, -17, 45, 6, -78, 3, 23};

        int n = arr.length;

        // Segment Tree
        int[] segtree = new int[4 * n];

        // Build
        buildSegTree(arr, segtree);

        System.out.println("Before Update:");
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Tree  : " + Arrays.toString(segtree));

        // Change index 2 -> 90
        updateValue(arr, 2, 90, segtree);

        System.out.println("\nAfter Update:");
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Tree  : " + Arrays.toString(segtree));

        System.out.println("\nMaximum = " + segtree[0]);
    }


    // ================= BUILD =================

    public static void buildSegTree(int[] arr, int[] segtree) {

        buildTree(
                arr,
                0,
                0,
                arr.length - 1,
                segtree
        );
    }


    public static int buildTree(
            int[] arr,
            int i,
            int start,
            int end,
            int[] segtree) {

        // Leaf node
        if (start == end) {
            return segtree[i] = arr[start];
        }

        int mid = start + (end - start) / 2;

        int left = buildTree(
                arr,
                2 * i + 1,
                start,
                mid,
                segtree
        );

        int right = buildTree(
                arr,
                2 * i + 2,
                mid + 1,
                end,
                segtree
        );

        return segtree[i] = Math.max(left, right);
    }


    // ================= UPDATE =================

    public static void updateValue(
            int[] arr,
            int index,
            int val,
            int[] segtree) {

        // Update original array
        arr[index] = val;

        // Update Segment Tree
        updateSegTree(
                arr,
                0,
                0,
                arr.length - 1,
                index,
                val,
                segtree
        );
    }


    public static int updateSegTree(
            int[] arr,
            int i,
            int start,
            int end,
            int index,
            int val,
            int[] segtree) {

        // Target leaf
        if (start == end) {
            return segtree[i] = val;
        }

        int mid = start + (end - start) / 2;

        // Go left
        if (index <= mid) {

            updateSegTree(
                    arr,
                    2 * i + 1,
                    start,
                    mid,
                    index,
                    val,
                    segtree
            );

        }
        // Go right
        else {

            updateSegTree(
                    arr,
                    2 * i + 2,
                    mid + 1,
                    end,
                    index,
                    val,
                    segtree
            );
        }

        // Recalculate current node
        segtree[i] = Math.max(
                segtree[2 * i + 1],
                segtree[2 * i + 2]
        );

        return segtree[i];
    }
}
