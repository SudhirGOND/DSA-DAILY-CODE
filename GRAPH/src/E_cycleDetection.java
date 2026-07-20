import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class E_cycleDetection {

    /// in the undirected graph

    public boolean isCycle(int V, int[][] edges) {


        //making of the adjacency list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>()); /// jitne numbetr utne empty list
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);   // because the graph is undirected
        }


        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited))
                    return true;
            }
        }
        return false;


    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {


        visited[node] = true;
        for (int neigh : adj.get(node)) {

            if (!visited[neigh]) {
                if (dfs(neigh, node, adj, visited)) {
                    return true;
                }
            } else if (neigh != parent) {
                return true;
            }
        }

        return false;


    }


    /// CODE OF BFS( detection of the undirected graph )

    class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();

        visited[start] = true;
        q.offer(new Pair(start, -1));

        while (!q.isEmpty()) {

            Pair current = q.poll();
            int node = current.node;
            int parent = current.parent;

            for (int neigh : adj.get(node)) {

                if (!visited[neigh]) {     /// not visited
                    visited[neigh] = true;   ///  marked them true ( neighbour)
                    q.offer(new Pair(neigh, node));//// put into the queue
                } else if (neigh != parent) { ///  if (  visited  && parent !=  node(neigh) )
                    // A visited neighbor that is not the parent indicates a cycle.
                    return true;
                }
            }
        }

        return false;
    }


}
