import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class M_MinimumEffort {


//    class Triplet implements Comparable<Triplet> {
//        int row;
//        int col;
//        int effort;
//
//        Triplet(int row, int col, int effort) {
//            this.row = row;
//            this.col = col;
//            this.effort = effort;
//        }
//
//        public int compareTo(Triplet other) {
//
//            return Integer.compare(this.effort, other.effort);
//        }
//    }
//
//    public int minimumEffortPath(int[][] arr) {
//
//        int m = arr.length;
//        int n = arr[0].length;
//
//        int[][] ans;
//        ans = new int[m][n];
//        for (int[] i : ans) {
//            Arrays.fill(i, Integer.MAX_VALUE);
//        }
//
//        ans[0][0] = 0;
//        /// made the priority queue
//
//        PriorityQueue<Triplet> pq = new PriorityQueue<>();
//        pq.add(new Triplet(0, 0, 0));
//
//        int r[] = {-1, 0, 1, 0};
//        int c[] = {0, -1, 0, 1};
//
//        while (!pq.isEmpty()) {
//
//            Triplet top = pq.poll();
//
//            int row = top.row, col = top.col, effort_next = top.effort;
//
//            if (row == m - 1 && col == n - 1)
//                return effort_next;
//            for (int i = 0; i <= 3; i++) { /// filling the array 2d
//
//                int newRow = row + r[i];
//                int newCol = col + c[i];
//
//                // main break point
//
//                if (newRow < 0 || newCol < 0 || newRow > m - 1 || newCol > n - 1)
//                    continue;
//                int e = Math.abs(arr[row][col] - arr[newRow][newCol]);
//                e = Math.max(e, effort_next);
//                if (e < ans[newRow][newCol]) {
//                    ans[newRow][newCol] = e;
//                    pq.add(new Triplet(newRow, newCol, e)); //// new triplet inserted
//                }
//            }
//
//        }
//
//        return ans[m - 1][n - 1];
//
//    }


    class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int effort;

        Triplet(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Triplet other) {
            if (this.effort == other.effort) return Integer.compare(this.row, other.row);
            return Integer.compare(this.effort, other.effort);
        }
    }


    public int minimumEffortPath(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;


        int[][] ans;
        ans = new int[m][n];
        for (int[] i : ans) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }


        ans[0][0] = 0;
        /// made the priority queue

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, 0, 0));


        while (!pq.isEmpty()) {
            Triplet top = pq.poll();
            int row = top.row, col = top.col, effort_next = top.effort;


            if (row == m - 1 && col == n - 1) break; //// reached at the last column


            if (row > 0) { /// goto the row -1
                int e = Math.abs(arr[row][col] - arr[row - 1][col]);
                e = Math.max(e, effort_next);
                if (e < ans[row - 1][col]) {
                    ans[row - 1][col] = e;
                    pq.add(new Triplet(row - 1, col, e)); //// new triplet inserted
                }
            }


            if (row < m - 1) { /// goto the row + 1
                int e = Math.abs(arr[row][col] - arr[row + 1][col]);
                e = Math.max(e, effort_next);
                if (e < ans[row + 1][col]) {
                    ans[row + 1][col] = e;
                    pq.add(new Triplet(row + 1, col, e)); //// new triplet inserted
                }
            }


            if (col > 0) { /// goto the col
                int e = Math.abs(arr[row][col] - arr[row][col - 1]);
                e = Math.max(e, effort_next);
                if (e < ans[row][col - 1]) {
                    ans[row][col - 1] = e;
                    pq.add(new Triplet(row, col - 1, e)); //// new triplet inserted
                }
            }

            if (col < n - 1) { /// goto the col +1
                int e = Math.abs(arr[row][col] - arr[row][col + 1]);
                e = Math.max(e, effort_next);
                if (e < ans[row][col + 1]) {
                    ans[row][col + 1] = e;
                    pq.add(new Triplet(row, col + 1, e)); //// new triplet inserted
                }
            }


        }


        return ans[m - 1][n - 1];


    }


}



