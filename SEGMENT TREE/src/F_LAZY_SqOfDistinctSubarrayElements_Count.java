import java.util.Arrays;

public class F_LAZY_SqOfDistinctSubarrayElements_Count {


    static final long MOD = 1_000_000_007L;
    int n;
    long[] sqSumSegTree;
    long[] sumSegTree;
    long[] lazyTree;

    // function to  return the required output
    public int sumCounts(int[] nums) {

        n = nums.length;
        sqSumSegTree = new long[4 * n];
        sumSegTree = new long[4 * n];
        lazyTree = new long[4 * n];

        /// find the last index of current_occurred (int)
        int[] lastindex = new int[1_000_01];
        Arrays.fill(lastindex, -1);

        long ans = 0; /// the  result
        for (int i = 0; i < n; i++) {
            // finding the range to update
            int start = lastindex[nums[i]] + 1;
            int end = i;

            updateRange(start, end, 0, 0, n - 1, 1);

            ans = (ans + sqSumSegTree[0]) % MOD;


            lastindex[nums[i]] = i; /// current index as last senn index ho jayega
        }


        return (int) ans;
    }

    private void updateRange(int start, int end, int i, int l, int r, int val) {
        /// check for the lazy ke paas pahle se valu hain to daal do

        if (lazyTree[i] != 0) {
            // lazy tree ko update krr rhen hain
            lazyAddition(i, l, r, lazyTree[i]);

            if (l != r) {
                lazyTree[2 * i + 1] += lazyTree[i];
                lazyTree[2 * i + 2] += lazyTree[i];

            }

            lazyTree[i] = 0; // ->  khali krr denge kyuki  upddate ho gya segment tree

        }
        // out of range
        if (l > end || r < start || l > r) {
            return;
        }

        // completely overlap kare to
        if (l >= start && r <= end) {
            lazyAddition(i, l, r, val);

            if (l != r) {
                lazyTree[2 * i + 1] += val;
                lazyTree[2 * i + 2] += val;

            }

            return;
        }

        // if mid range pade to
        int mid = l + (r - l) / 2;
        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        sumSegTree[i] = sumSegTree[2 * i + 1] + sumSegTree[2 * i + 2];
        sqSumSegTree[i] = sqSumSegTree[2 * i + 1] + sqSumSegTree[2 * i + 2];


    }

    private void lazyAddition(int i, int l, int r, long val) {
        long len = r - l + 1;

        /// main chij yaha hain
        /// if(sum  ko lazy tree mein rakhna ho to )

        ///Update normal sum
        /// newSum = oldSum + len*v;
        /// // Step 1: Expand the square
        /// (x + v)² = x² + 2*x*v + v²
        /// // Step 2: Sum over all elements
        /// sum((x + v)²) = sum(x²) + 2*v*sum(x) + len*v²
        /// // Step 3: Final formula
        /// newSqSum = oldSqSum + 2*v*oldSum + len*v*v;

        sqSumSegTree[i] += 2 * val * sumSegTree[i] + len * val * val;
        sumSegTree[i] += len * val;

    }

}

/****************competitive code ****************************************************************************/
class competitive {

    static final long MOD = 1_000_000_007L;

    int n;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;

            update(l, i, 0, 0, n - 1, 1);
            ans = (ans + sq[0]) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void apply(int i, int l, int r, long v) {
        long len = r - l + 1L;
        long oldSum = sum[i];

        sq[i] = (sq[i] + 2L * v % MOD * oldSum % MOD
                + len % MOD * v % MOD * v % MOD) % MOD;

        sum[i] = (oldSum + len % MOD * v % MOD) % MOD;
        lazy[i] = (lazy[i] + v) % MOD;
    }

    void push(int i, int l, int r) {
        if (lazy[i] == 0 || l == r) return;

        int m = (l + r) / 2;

        apply(2 * i + 1, l, m, lazy[i]);
        apply(2 * i + 2, m + 1, r, lazy[i]);

        lazy[i] = 0;
    }

    void update(int ql, int qr, int i, int l, int r, long v) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(i, l, r, v);
            return;
        }

        push(i, l, r);

        int m = (l + r) / 2;

        update(ql, qr, 2 * i + 1, l, m, v);
        update(ql, qr, 2 * i + 2, m + 1, r, v);

        sum[i] = (sum[2 * i + 1] + sum[2 * i + 2]) % MOD;
        sq[i] = (sq[2 * i + 1] + sq[2 * i + 2]) % MOD;
    }
}


