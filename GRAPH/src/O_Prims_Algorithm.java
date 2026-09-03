import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//  the intuition added
//Start from any node and mark it visited.
//Add all its edges to a min-heap (PriorityQueue).
//Pick the cheapest edge from the heap.
//If its destination is unvisited, add that edge to the MST.
//Mark the new node visited and add its edges to the heap.
//Repeat until all nodes are visited.
//Sum the selected edge weights to get the MST cost.

public class O_Prims_Algorithm {

    // Stores edge information
    static class Triplet {

        int node;     // current node
        int parent;   // node from which we reached current node
        int weight;   // edge weight

        Triplet(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        // Edge list representation: {source, destination, weight}
        int[][] graph = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7},
                {3, 4, 9}
        };


        int vertices = 5;


        // Creating adjacency list
        List<List<Triplet>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }


        // Adding edges in adjacency list
        // Graph is undirected, so add both directions
        for (int[] edge : graph) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Triplet(v, u, wt));
            adj.get(v).add(new Triplet(u, v, wt));
        }


        // To track visited nodes
        boolean[] visited = new boolean[vertices];


        // Stores the MST edges
        List<Triplet> mst = new ArrayList<>();


        // Min heap based on edge weight
        PriorityQueue<Triplet> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));


        // Start Prim's algorithm from node 0
        // node = 0, parent = -1, weight = 0
        pq.add(new Triplet(0, -1, 0));


        int totalWeight = 0;


        // Continue until all possible edges are processed
        while (!pq.isEmpty()) {


            // Get minimum weight edge
            Triplet top = pq.poll();


            int node = top.node;
            int parent = top.parent;
            int weight = top.weight;


            // If node is already included in MST, skip it
            if (visited[node])
                continue;


            // Mark node as included in MST
            visited[node] = true;


            // Store this edge in MST
            if (parent != -1) {
                mst.add(top);
                totalWeight += weight;
            }


            // Explore all neighbouring nodes
            for (Triplet neighbour : adj.get(node)) {


                // If neighbour is not already included,
                // add the edge into priority queue
                if (!visited[neighbour.node]) {

                    pq.add(new Triplet(
                            neighbour.node,
                            node,
                            neighbour.weight
                    ));
                }
            }
        }


        // Printing MST edges
        System.out.println("Edges in MST:");

        for (Triplet edge : mst) {

            System.out.println(
                    edge.parent + " - "
                            + edge.node
                            + " : "
                            + edge.weight
            );
        }


        System.out.println("Total MST Weight = " + totalWeight);

    }
}