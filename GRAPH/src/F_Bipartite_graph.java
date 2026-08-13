import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Intuition Added
//Goal: Check if the graph can be divided into 2 colors.
//-1: Node is unvisited/uncolored.
//0/1: Represent the two colors.
//BFS: Start from each unvisited node.
//1 - color: Give the neighbor the opposite color.
//Same color: If connected nodes have the same color → Not Bipartite.
//Outer loop: Handles disconnected components.
//Final: If no same-colored adjacent nodes → Bipartite


public class F_Bipartite_graph {

    static boolean ans;

    public boolean isBipartite(int[][] adj) {

        ans = true;
        int n = adj.length;
        int[] visited = new int[n]; // making the visition of the traversing
        Arrays.fill(visited, -1);


        for (int i = 0; i < n; i++) {
            if (!ans) return ans;
            if (visited[i] == -1)
                bfs(i, adj, visited);
        }
        return ans;
    }

    private void bfs(int i, int[][] adj, int[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[i] = 0; /// give them color 0  means blue and 1 means red
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.poll();
            int color = visited[front];
            for (int ele : adj[front]) { ///adj Matrix behave like the  adjacency list
                if (visited[ele] == visited[front]) { ///  parent se front  !=  same color

                    ans = false;
                    return;

                }

                if (visited[ele] == -1) {
                    visited[ele] = 1 - color; //// another color filled
                    q.add(ele);
                }

            }
        }


    }
}
