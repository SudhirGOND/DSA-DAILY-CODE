import java.util.LinkedList;
import java.util.Queue;

public class A_NumberOfProvinces {


    public int findCircleNum(int[][] adj) {
        int count = 0;
        int n = adj.length;
        boolean[] visit = new boolean[adj.length + 1]; ///  false

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {
                bfs(i, visit, adj);
                count++;
            }
        }


        return count;


    }

    private void bfs(int i, boolean[] visit, int[][] adj) {

        int n = adj.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(i); // adding the first node
        visit[i] = true;/// marked
        while (!q.isEmpty()) {

            int front = q.remove();
            for (int j = 0; j < n; j++) {
                if (adj[front][j] == 1 && !visit[j]) {
                    q.add(j);
                    visit[j] = true;
                }
            }
        }

    }

}
