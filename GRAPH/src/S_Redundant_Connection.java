public class S_Redundant_Connection {


    /// // cycle detection throught the DSU
    /// / the code is of the redundant connection

    static int[] parent;
    static int[] size;

    public int[] findCycle(int[][] edges) {

        int n = edges.length;
        // parent array ko intialise karenge
        // also initialize the size array
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) { ///  1 based indexing -->
            parent[i] = i;
            size[i] = 1;
        }

        // return the answer in the 2 sie array
        int[] ans = new int[2];

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            if (leader(u) == leader(v)) { /// cycle detected
                ans[0] = u;
                ans[1] = v;
                break;
            } else {
                union(u, v);
            }
        }

        return ans;
    }

    private int leader(int u) {
        if (parent[u] == u) return u;
        return parent[u] = leader(parent[u]);


    }

    void union(int u, int v) {
        int a = leader(u);
        int b = leader(v);

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


}
