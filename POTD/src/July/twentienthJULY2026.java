package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twentienthJULY2026 {

    /// the BRUTE FORCE SOLUTION
//    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
//
//        // We have given the grid (2d_array) Swap the things or do(shift ) k times
//        // Its time complexity ->  O((k-1)*m**n) //cubic
//        // Its space complexity --> O(n*m)
//
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int temp[][] = new int[m][n];
//        k = k % (m * n); /// the shift operation repeats itself
//        if (k == 0) {
//            temp = grid; //// the edge case
//        }
//        while (k > 0) {
//
//            temp = new int[m][n];
//
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//
//                    if (j < n - 1) {
//                        temp[i][j + 1] = grid[i][j];
//                    } else {
//                        if (i < m - 1)
//                            temp[i + 1][0] = grid[i][j];
//                        else
//                            temp[0][0] = grid[i][j];
//                    }
//
//                }
//            }
//
//            grid = temp; /// swap the old grid to the new one
//            k--;
//        }
//
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int[] row : temp) {
//            List<Integer> inner = new ArrayList<>();
//            for (int val : row)
//                inner.add(val);
//            ans.add(inner);
//        }
//        return ans;
//    }


    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {

            int m = grid.length;
            int n = grid[0].length;
            int total = m * n;

            k %= total; ///  the main logic

            int[][] ansGrid = new int[m][n];
            ///converting the 2d to 1d arrray
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    int currentIndex = i * n + j;  /// 1 d array index
                    int newIndex = (currentIndex + k) % total; /// after shifting inddex in 1d array

                    int newRow = newIndex / n; //  new row index
                    int newCol = newIndex % n; //  new col index

                    ansGrid[newRow][newCol] = grid[i][j]; ///storing the values old to the ans array 2d ( using the new indices )
                }
            }

            List<List<Integer>> ans = new ArrayList<>();

            for (int[] row : ansGrid) {
                List<Integer> list = new ArrayList<>();
                for (int val : row) {
                    list.add(val);
                }
                ans.add(list);
            }

            return ans;
        }
    }


}
