public class V_Union_Disjoint_class {


//Initialize each node as its own parent and set size[i] = 1.
//    Find the ultimate parent of both nodes using find().
//    If both nodes have the same parent, do nothing.
//    Compare the sizes of the two sets.
//    Attach the smaller set under the larger set.
//    Update the size of the new parent:
//    size[newParent] += size[oldParent]
//    Repeat for every union operation.

    private class DSU {

        int[] parent;
        int[] size;

        // Constructor
        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            // Initially, every node is its own parent
            // and every set has size 1
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find ultimate parent / leader
        int find(int x) {

            if (parent[x] == x) {
                return x;
            }

            // Path Compression
            return parent[x] = find(parent[x]);
        }

        // Union two sets
        boolean union(int a, int b) {

            // Find ultimate parents
            a = find(a);
            b = find(b);

            // Already in the same set
            if (a == b) {
                return false;
            }

            // Union by Size
            if (size[a] >= size[b]) {

                parent[b] = a;
                size[a] += size[b];

            } else {

                parent[a] = b;
                size[b] += size[a];
            }

            return true;
        }


    }

}
