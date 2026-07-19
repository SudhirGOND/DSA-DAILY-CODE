import java.util.ArrayList;

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


}
