import java.util.*;


//Goal: Find how long it takes for the signal from k to reach all nodes.
//Main idea: Find the shortest distance from k to every node.
//        Algorithm: Use Dijkstra because all edge weights are positive.
//Adjacency list: Store each node's outgoing (neighbor, weight) edges.
//distArray: Store the currently known shortest distance from k to each node.
//        Initialize: Set dist[k] = 0 because the signal starts at k.
//Min-heap: Always process the node having the smallest known distance.
//        Relaxation: For every neighbor, calculate newDist = currentDist + edgeWeight.
//        Update: If newDist < dist[neighbor], update the distance and push it into the heap.
//        Repeat: Continue until the priority queue becomes empty.
//Unreachable node: If any node's distance is still Integer.MAX_VALUE, return -1.
//Final answer: Take the maximum shortest distance, because the last node to receive the signal determines the total delay.


public class K_NetworkDelay_DIJKSTRA {

    class Pair {

        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

    }

    public int networkDelayTime(int[][] graph, int n, int k) {

        //making of the adjacency list
        List<List<int[]>> adj = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] row : graph) {
            int u = row[0];
            int v = row[1];
            int dist = row[2];

            adj.get(u).add(new int[]{v, dist}); // u -->  v and the weight
        }

        /// PriorityQueue<Pair> pq = new PriorityQueue<>(); // the simple way the
        /// advacnced style of the comparing
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        int distArray[] = new int[n + 1];
        Arrays.fill(distArray, Integer.MAX_VALUE); /// filled with max value

        //// now the min heap logic is going to implement
        distArray[0] = 0;
        distArray[k] = 0; /// intialises
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int currNode = top.node;
            int currDist = top.dist;

            if (currDist > distArray[currNode]) {
                continue; /// skip this iteration
            }
            for (int[] row : adj.get(currNode)) {

                int v = row[0];
                int dist = row[1];
                int totalDist = currDist + dist;
                if (totalDist < distArray[v]) {
                    distArray[v] = totalDist; //  usss chota
                    pq.offer(new Pair(v, totalDist)); /// < node , dist> }
                }
            }
        }

        // max dist means max time taken to transmit the signal ( max fromthe distArray)
        int max = Integer.MIN_VALUE;
        for (int i : distArray) {

            max = Math.max(i, max);
            if (max == Integer.MAX_VALUE)
                return -1;
        }

        return max;
    }


}
