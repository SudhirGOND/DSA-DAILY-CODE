import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_Key_Rooms {


    public boolean canVisitAllRooms(List<List<Integer>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        visited[0] = true; /// from quetion we get tbhe access
        bfs(0, adj, visited);
        for (boolean ele : visited) {
            if (!ele) return false;

        }
        return true;
    }

    private void bfs(int start, List<List<Integer>> adj, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int front = q.remove(); //the first list array which have the access to us
            for (int ele : adj.get(front)) {
                if (!visited[ele]) { //// visited  ==false
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

}
