import java.util.ArrayList;

public class G_Topological_Sort {


    /// / the DFS approach

    public static void main(String[] args) {

        /// it works as the adjacency list 
        int[][] adj = {
                {1},
                {2, 3},
                {4, 3},
                {},
                {3}
        };

        topological(adj);
    }

    private static void topological(int[][] adj) {


        int n = adj.length;
        // for marking the visited things
        boolean[] visited = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            /// if not visited then dfs
            if (!visited[i])
                dfs(i, visited, adj, ans);
        }


        System.out.println("TOPOLOGICAL SORTING " + ans.reversed());
//        System.out.println(ans.reversed());


    }

    private static void dfs(int i, boolean[] visited, int[][] adj, ArrayList<Integer> ans) {

        visited[i] = true;
        for (int ele : adj[i]) {
            if (!visited[ele]) {
                dfs(ele, visited, adj, ans);

            }

        }
        /// in the end --> during the backtracking
        /// stored the answer
        ans.add(i);

    }

}
