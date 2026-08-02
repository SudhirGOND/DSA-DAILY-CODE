import java.util.Arrays;

public class P_Bellmon_Ford {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 30},
                {0, 3, 20},
                {0, 4, 5},
                {4, 2, 8},
                {4, 3, 6},
                {2, 1, 4},
                {2, 3, 7}
        };

        int n = 5;
        int src = 0;

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax edges (V-1) times
        for (int i = 1; i < n; i++) {

            boolean updated = false;

            for (int j = 0; j < graph.length; j++) {

                int u = graph[j][0];
                int v = graph[j][1];
                int wt = graph[j][2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                    updated = true;
                }
            }

            // Optimization
            if (!updated)
                break;
        }

        System.out.println(Arrays.toString(dist));

        // Check Negative Cycle
        for (int i = 0; i < graph.length; i++) {

            int u = graph[i][0];
            int v = graph[i][1];
            int wt = graph[i][2];

            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                System.out.println("Negative Cycle Detected");
                return;
            }
        }

        System.out.println("No Negative Cycle");
    }
}