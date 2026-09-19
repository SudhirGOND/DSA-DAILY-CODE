import java.util.Arrays;

public class A_CreatingTheNode {

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

    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, arr.length - 1);
        System.out.println(Arrays.toString(tree));

    }
}
