import java.util.*;
import java.util.Queue;

public class H_Kahns_Algorithm {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Build graph and calculate indegree
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);

            indegree[v]++; ///  adding the frequency
        }


        Queue<Integer> q = new LinkedList<>();

        // Add nodes having indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();


        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);


            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }


        return ans;
    }
}
