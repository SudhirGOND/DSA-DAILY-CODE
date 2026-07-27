import java.util.*;

public class L_MostProbablityPATH {


    class Pair implements Comparable<Pair> {

        int node;
        double probab;
        Pair(int node, double probab){
            this.node = node;
            this.probab = probab;
        }

        public int compareTo(Pair other) {
            return Double.compare(this.probab, other.probab);
        }
    }

    public double maxProbability(int n, int[][] graph, double[] prob, int start, int end) {


        /// made the adjacency list from the graph

        /// made  the required and array( and initialize the start node )

        /// made the min/max heap according to the need
        /// Initialize with the pair( insertion in the heap)

        /// applying the Dijkstra Algorithm

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            double pro = prob[i];

            adj.get(u).add(new Pair(v, pro));
            adj.get(v).add(new Pair(u, pro));
        }


        double ans[] = new double[n];
        ans[start] = 1; /// 100% probability



        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probab, a.probab));

        pq.add(new Pair(start , 1));
        while( !pq.isEmpty()){
            Pair top =  pq.poll();
            int node = top.node;
            double probFromSrc = top.probab;
            if(probFromSrc < ans[node]) continue;
            for(Pair p : adj.get(node)){
                int vertex = p.node;
                double wt = p.probab;
                double totalDist = probFromSrc * wt; // VV IMP
                if(totalDist > ans[vertex]){
                    pq.add(new Pair(vertex,totalDist));
                    ans[vertex] = totalDist;
                }
            }
        }
        return ans[end];

    }
}
