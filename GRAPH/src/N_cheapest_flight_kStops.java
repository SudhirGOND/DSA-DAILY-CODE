import java.util.*;

public class N_cheapest_flight_kStops {


    class Triplet implements Comparable<Triplet> {

        int from;
        int stop;
        int price;

        Triplet(int from, int stop, int price) {
            this.from = from;
            this.stop = stop;
            this.price = price;

        }

        public int compareTo(Triplet other) {
            return this.price - other.price;
        }
    }

    class Pair {
        int node;
        int price;

        Pair(int node, int price) {
            this.node = node;
            this.price = price;

        }
    }


    /// / THE BELOW CODE GIVE THE WRONG ANSWER BECAZ IT FOLLOW THE GREEDY APPROACH
    /// NOT NECESSSARY IT GIVES THE RIGHT ANSWER
    /// SO TRY To insert on the basis of  STOPS (K )--> in the heap
    public int findCheapestPrice(int n, int[][] arr, int src, int dst, int k) {

        /// made the adjacency list of the flights
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int paisa = arr[i][2];

            adj.get(u).add(new Pair(v, paisa));

        }

        // made thee ans array

        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[src] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(src, 0, 0)); /// < node , paiss

        while (!pq.isEmpty()) {

            Triplet node = pq.poll();

            int next = node.from;
            int stop = node.stop;
            int price = node.price;

            /// main break condition
            if (next == dst)
                return price;
            if (stop == k + 1)
                continue;

            for (Pair p : adj.get(next)) {
                int totalcost = price + p.price; /// for the next node
                if (totalcost < ans[p.node]) {
                    ans[p.node] = totalcost;
                    pq.add(new Triplet(p.node, stop + 1, totalcost));
                }
            }
        }
        if (ans[dst] == Integer.MAX_VALUE)
            return -1;


        return ans[dst];
    }

    public int findCheapestPrice2(int n, int[][] arr, int src, int dst, int k) {

        /// made the adjacency list of the flights
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int paisa = arr[i][2];

            adj.get(u).add(new Pair(v, paisa));

        }

        // made thee ans array

        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[src] = 0;
        /// we not need the heap we can do our work using the queue only atomatically FIFO is happening in case of the STOP

        Queue<Triplet> pq = new LinkedList<>();

        pq.add(new Triplet(src, 0, 0)); /// < node , paiss

        while (!pq.isEmpty()) {

            Triplet node = pq.poll();

            int next = node.from;
            int stop = node.stop;
            int price = node.price;

            /// main break condition
            // if (next == dst)
            //     return price;
            if (stop == k + 1)
                continue;

            for (Pair p : adj.get(next)) {
                int totalcost = price + p.price; /// for the next node
                if (totalcost < ans[p.node]) {
                    ans[p.node] = totalcost;
                    pq.add(new Triplet(p.node, stop + 1, totalcost));
                }
            }
        }
        if (ans[dst] == Integer.MAX_VALUE)
            return -1;
        return ans[dst];
    }






}
