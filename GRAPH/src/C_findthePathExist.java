import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C_findthePathExist {


    public static boolean validPath(int n, int[][] edges, int start, int end) {
        //// we convert into the list style
        if (start == end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // vacant list inserted into all positions

        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b); //  a-->  b
            adj.get(b).add(a); //  b -->  a
        }
        boolean[] visited = new boolean[n];
        visited[start] = true; /// starting from this place
        bfs(start, adj, visited, end);
        return visited[end];

    }

    private static void bfs(int start, List<List<Integer>> adj, boolean[] visited, int end) {


        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int source = q.poll();
            for (int ele : adj.get(source))
                if (!visited[ele]) {
                    visited[ele] = true;
                    if (ele == end) return;
                    q.add(ele);
                }
        }

    }
}
