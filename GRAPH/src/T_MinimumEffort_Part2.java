import java.util.ArrayList;
import java.util.PriorityQueue;

class T_MinimumEffort_Part2 {


    /// Doing it by the using the DSU(Function)
    static int[] parent;
    static int[] size;


    public void union(int a, int b) {
        a = findleader(a);
        b = findleader(b);

        if (a != b) {


            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }

    }

    private int findleader(int a) {

        if (parent[a] == a) return a;
        return parent[a] = findleader(parent[a]);
    }

    class Edge implements Comparable<Edge> {
        int u;
        int v;
        int dist;

        Edge(int u, int v, int dist) {

            this.dist = dist;
            this.u = u;
            this.v = v;

        }

        public int compareTo(Edge E) {

            return Integer.compare(this.dist, E.dist);

        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // for the smallest element only
        /// alternative will be the edge list->  after the filled we sort the edge list according the the basis of the dist
        // traversing the matrix given and adding into the priority queue
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int x1 = points[u][0], y1 = points[u][1];
                int x2 = points[v][0], y2 = points[v][1];
                int cost = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                pq.add(new Edge(u, v, cost));

            }
        }
        // The above code increases the Time Complexity as the n^2
        // So we build the Adjacency List


        int minCost = 0; // the result
        while (!pq.isEmpty()) {


            Edge next = pq.poll();

            int u = next.u;
            int v = next.v;
            int cost = next.dist;

            if (findleader(u) != findleader(v)) {
                minCost += cost;
                union(u, v);
            }
        }

        return minCost;
    }

}
