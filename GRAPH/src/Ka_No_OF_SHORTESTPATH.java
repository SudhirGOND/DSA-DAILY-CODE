import java.util.*;
import java.util.ArrayList;

public class Ka_No_OF_SHORTESTPATH {

//
//    Use Dijkstra because we need the shortest time in a weighted graph.
//
//    Maintain:
//
//    dist[i] → shortest time to reach i
//    ways[i] → number of shortest ways to reach i
//    Initially:
//
//    dist[0] = 0
//    ways[0] = 1
//
//
//    For an edge u → v:
//
//    If newDist < dist[v]:
//    Found a better path
//    dist[v] = newDist
//    ways[v] = ways[u]
//    If newDist == dist[v]:
//    Found another shortest path
//    ways[v] += ways[u]
//    Take ways[v] % (1e9 + 7) because the count can be huge.

    class Solution {

        static final long MOD = 1_000_000_007L;

        class Pair {
            int node;
            long dist;

            Pair(int node, long dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public int countPaths(int n, int[][] roads) {

            List<List<int[]>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] road : roads) {
                int u = road[0];
                int v = road[1];
                int time = road[2];

                adj.get(u).add(new int[]{v, time});
                adj.get(v).add(new int[]{u, time});
            }

            PriorityQueue<Pair> pq =
                    new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);

            long[] ways = new long[n];

            dist[0] = 0;
            ways[0] = 1;

            pq.offer(new Pair(0, 0));

            while (!pq.isEmpty()) {

                Pair current = pq.poll();

                int u = current.node;
                long currDist = current.dist;

                // Ignore outdated entry
                if (currDist > dist[u]) {
                    continue;
                }

                for (int[] edge : adj.get(u)) {

                    int v = edge[0];
                    long time = edge[1];

                    long newDist = currDist + time;

                    // New shortest path
                    if (newDist < dist[v]) {

                        dist[v] = newDist;

                        // Every shortest path to u
                        // creates a shortest path to v
                        ways[v] = ways[u];

                        pq.offer(new Pair(v, newDist));
                    }

                    // Another shortest path
                    else if (newDist == dist[v]) {

                        ways[v] =
                                (ways[v] + ways[u]) % MOD;
                    }
                }
            }

            return (int) ways[n - 1];
        }
    }

}
