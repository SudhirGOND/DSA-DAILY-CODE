public class U_graph_bipartite_Part2 {


    static int[] parent, size;
    static boolean[] parity;

    /// chek the already visited or not
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n]; /// 0 -- > N-1



        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;

        }



        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int u = i, v = graph[i][j];

                if (v > u) { //// we avoiid the duplicate conditions(multiple times)
                    if (findleader(u) == findleader(v)) {/// cycle detected
                        if (parity[u] == parity[v])
                            return false;
                    } else
                        union(u, v);
                }
            }
        }
        return true;
    }

    public void union(int u, int v) {
        int a = findleader(u);
        int b = findleader(v);

        if (a != b) {

            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
                parity[v] = !parity[u];
            } else {
                parent[a] = b;
                size[b] += size[a];
                parity[u] = !parity[v];
            }
        }

    }

    public int findleader(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = findleader(parent[a]);
    }

}