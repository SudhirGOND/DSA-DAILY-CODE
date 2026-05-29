

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Triplet {
    int dist;
    int x;
    int y;

    Triplet(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

//    class Triplet implements Comparable{
//        return Double.toCompare()
//    }
}

public class K_closest {
    public int[][] kclosest(int[][] points, int k) {
        /// k smallest distances ->  maxheap
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            /// 2d array mein se 1D array nikal lenge

            int x = point[0], y = point[1]; ///
            int dist = x * x + y * y; /// distance nikal liye
            pq.add(new Triplet(dist, x, y)); // triplet bnake stored kra diye
            if (pq.size() > k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;

        }

        return ans;

    }


}
