import java.util.Arrays;

//Feature	                    Bellman-Ford	Dijkstra
//Single source	                    ✅          	✅
//Negative edges	                ✅	            ❌
//Negative cycle detection	        ✅	            ❌
//Time	                            O(VE)	      Usually faster
//Basic idea	            Repeated relaxation	   Greedy
//Faster?	                       ❌	             ✅


//Dijkstra = faster, but no negative edges.
//Bellman-Ford = slower, but supports negative edges and detects negative cycles.


//Purpose: Find the shortest paths from one source.
//Start: Source = 0, others = ∞.
//Relax: dist[v] = min(dist[v], dist[u] + wt).
//Repeat: Relax all edges V−1 times.
//Why V−1: Shortest path has at most V−1 edges.
//Negative edges: ✅ Supported.
//Negative cycle: Extra pass + any improvement → negative cycle.
//Optimization: No update → stop early.
//Time: O(VE).
//Space: O(V).
//Key idea: Keep improving distances until they stabilize.



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