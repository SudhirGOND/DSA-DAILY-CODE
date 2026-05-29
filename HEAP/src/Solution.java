import java.util.*;
import java.util.PriorityQueue;

public class Solution {

    public class Triplet implements Comparable<Triplet> {
        int ele;
        int row;
        int col;


        Triplet(int ele, int row, int col) {
            this.row = row;
            this.col = col;
            this.ele = ele;
        }

        public int compareTo(Triplet t) {
            return this.ele - t.ele;/// comparing for the element
        }
    }


    public ArrayList<Integer> findSmallestRange(int[][] arr) {

        /// stored the min element
        int k = arr.length;/// number of the 1d ARRAYS
        int n = arr[0].length; ////  number of the 2D arrays
        PriorityQueue<Triplet> pq = new PriorityQueue<>(); ///  minheap

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i][0]);
            min = Math.min(min, arr[i][0]);
            pq.add(new Triplet(arr[i][0], i, 0));
        }

        int a = min, b = max;
        while (true) {
            Triplet top = pq.remove();
            int ele = top.ele, row = top.col, col = top.col;
            if (max - ele < b - a) {
                a = ele;
                b = max;
            }
            if (col == n - 1) break;
            int next = arr[row][col + 1];
            max = Math.max(max, next);
            pq.add(new Triplet(next, row, col + 1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);

        return ans;
    }


}