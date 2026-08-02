import java.util.Arrays;

public class Q_Floyd_Warshall_Algorithm {


    public int findTheCity(int n, int[][] graph, int threshold) {
        //we are going to find the shortest distance -> all pairs
        // Apply the Floyd-Warshall Algorithm

        // Made the distance array 2D
        // try to fill the array by traversing --> k times

        // then find the city (node ) which have the minimum neighbors connected <=  threshold

        int[][] distArray = new int[n][n];

        for (int[] row : distArray) {
            Arrays.fill(row, Integer.MAX_VALUE);

        }

        for (int[] row : graph) {
            int u = row[0];
            int v = row[1];
            int wt = row[2];

            distArray[u][v] = wt;
            distArray[v][u] = wt; // as it is directed

        }

        /// floyd-warshall algorithm

        for (int k = 0; k < n; k++) {  // via k ( node)

            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k) continue;
                    if (distArray[i][k] != Integer.MAX_VALUE && distArray[k][j] != Integer.MAX_VALUE) {
                        distArray[i][j] = Math.min(distArray[i][j], distArray[i][k] + distArray[k][j]);
                    }

                }
            }
        }
        /// all the 2D matrix is filled easily

        // now find the less neighbor count ans neighbor

        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (distArray[i][j] <= threshold) {
                    count++;
                }


            }


            if (minCount >= count) {
                minCount = count;
                minCity = i;
            }
        }

        return minCity;

    }


}
