public class R_Disjoint_Set_Union {

//    static class DisjointSet {
//        private final int[] parent;
//        private final int[] rank;
//
//        // Constructor to initialize parent and rank arrays
//        public DisjointSet(int n) {
//            parent = new int[n];
//            rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;   // each node is its own parent initially
//                rank[i] = 0;     // rank starts at 0
//            }
//        }
//
//        // Find with path compression
//        public int findParent(int node) {
//            if (parent[node] != node) {
//                parent[node] = findParent(parent[node]); // path compression
//            }
//            return parent[node];
//        }
//
//        // Union by rank
//        public void union(int u, int v) {
//            int parentU = findParent(u);
//            int parentV = findParent(v);
//
//            if (parentU == parentV) return; // already in the same set
//
//            if (rank[parentU] < rank[parentV]) {
//                parent[parentU] = parentV;
//            } else if (rank[parentU] > rank[parentV]) {
//                parent[parentV] = parentU;
//            } else {
//                parent[parentV] = parentU;
//                rank[parentU]++; // increase rank if both have same rank
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        // Example usage
//        int n = 5; // number of elements (0 to 4)
//        DisjointSet ds = new DisjointSet(n);
//
//        // Perform some unions
//        ds.union(0, 1);
//        ds.union(1, 2);
//        ds.union(3, 4);
//
//        // Check parents
//        System.out.println("Parent of 0: " + ds.findParent(0));
//        System.out.println("Parent of 1: " + ds.findParent(1));
//        System.out.println("Parent of 2: " + ds.findParent(2));
//        System.out.println("Parent of 3: " + ds.findParent(3));
//        System.out.println("Parent of 4: " + ds.findParent(4));
//
//        // Check if two nodes are connected
//        if (ds.findParent(0) == ds.findParent(2)) {
//            System.out.println("0 and 2 are in the same set.");
//        } else {
//            System.out.println("0 and 2 are in different sets.");
//        }
//
//        if (ds.findParent(0) == ds.findParent(4)) {
//            System.out.println("0 and 4 are in the same set.");
//        } else {
//            System.out.println("0 and 4 are in different sets.");
//        }
//    }


    /// // finding the number of  connected component using the DSU (Disjoint Set Union)


//Initialize each node as its own parent and set size[i] = 1.
//    Find the ultimate parent of both nodes using find().
//    If both nodes have the same parent, do nothing.
//    Compare the sizes of the two sets.
//    Attach the smaller set under the larger set.
//    Update the size of the new parent:
//    size[newParent] += size[oldParent]
//    Repeat for every union operation.

    static int[] parent;
    static int[] size;

    ///  this store the  size of the tree formed
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        size = new int[n + 1]; /// 1  ->  n nodes
        parent = new int[n + 1]; ///  1 to n Nodes
        for (int i = 1; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        /// we need to convert the adjacency list to the edge list

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // edge is from i+1  to  j+1
                if (i != j && isConnected[i][j] == 1)
                    unionLeader(i + 1, j + 1); ///  connecting group leader of  i+1 and j +1
            }
        }


        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 1) count++; /// jjitne parent uthne connected component
        }

        return count;

    }


    // here we find the union leader

//    private void unionLeader(int a, int b) {
//        a = findleader(a);
//        b = findleader(b);
//
//        if (a != b) {
//            parent[b] = a;/// hum connect krr rhe  a--> b se or vice versa bhi ho sakta
//        }
//
//    }
//
//
//    /// we find the group leader or the set leader
//
//    private int findleader(int a) {
//
//        if (parent[a] == a) return a;
//        return findleader(parent[a]);
//    }

    /// THE TIME COMPLEXITY OF  THE CODE
    /// int  n^2 for the  traversing the nodes
    // n for the counting
    //union finding -> may -> O(n)
    // find --> recursion stack se ->  O ( n )


    //////******************************//////

    /// / we are going to write the optimized solution -> in the less time complexity
    private void unionLeader(int a, int b) {

        a = findleader(a);
        b = findleader(b);
        //Were optimized the solution on the basis of the the size

        if (a != b) {
            if (size[a] > size[b]) { // A should be parent of b

                parent[b] = a;/// hum connect krr rhe  a--> b se or vice versa bhi ho sakta
                size[a] += size[b];

            } else {
                parent[b] = a;
                size[b] += size[a];
            }
        }

    }


    /// we find the group leader or the set leader

    private int findleader(int a) {

        if (parent[a] == a) return a;
        return parent[a] = findleader(parent[a]);
    }




}
