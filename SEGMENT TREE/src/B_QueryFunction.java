public class B_QueryFunction {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int arr[], int i, int st, int end) {

        if (st == end) {
            tree[i] = arr[st];
            return arr[st];
        }

        int mid = (st + end) / 2;

        int l = buildST(arr, 2 * i + 1, st, mid); ///  the left subtree -->  2*i+1
        int r = buildST(arr, 2 * i + 2, mid + 1, end); ///   the right subtree  -> 2*i + 2;

        tree[i] = l + r;
        return tree[i];

    }


    public static int getSubarraySum(int[] arr, int qi, int qj) {
        int n = arr.length;

        return getSum(0, 0, n - 1, qi, qj);
    }


    public static int getSum(int idx, int si, int sj, int qi, int qj) {
        ///case 1  ->  non - overlap
        if (sj <= qi || qj <= si) return 0;
        else if (si >= qi && sj <= qj) { ///fully overlap
            return tree[idx];
        } else {    ////partial overlap
            int mid = (si + sj) / 2;
            int left = getSum(2 * idx + 1, si, mid, qi, qj);
            int right = getSum(2 * idx + 2, mid + 1, sj, qi, qj);
            return left + right;
        }


    }
    // what happen when we update the value at any index  in the array


    public static void update(int[] arr, int idx, int newval) {

        int diff = newval - arr[idx];
        arr[idx] = newval;
        updateUtil(0, 0, arr.length - 1, idx, diff);

    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        /// case 1
        if (idx > sj || idx < si) return;

        tree[i] += diff;

        if (si != sj) {

            /// non - leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);


        }

    }

    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, arr.length - 1);

        // Query likhna hain to tumhe (  a ->  b  ) kuch task perform krna hota
        int result = getSubarraySum(arr, 2, 5);
        System.out.println("Before Updation :" + result);
        update(arr, 2, 5);
        int newResult = getSubarraySum(arr, 2, 5);
        System.out.println("After updation :" + newResult);


    }
}
