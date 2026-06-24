import java.util.HashMap;
import java.util.PriorityQueue;

class D_kfrequent {


    class Pair implements Comparable<Pair> {


        int ele;
        int freq;


        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            if (this.freq == p.freq) return this.ele - p.ele;
            return this.freq - p.freq;
        }
    }


    public int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(); //  the hashmap
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1); ///element milegea to frq +11 vrna  0
        }

        /// we have to find the maximum

        PriorityQueue<Pair> pq = new PriorityQueue<>(); ///  minheap
        for (int ele : map.keySet()) {

            int freq = map.get(ele);
            pq.add(new Pair(ele, freq));

            if (pq.size() > k) pq.remove();
        }


        int size = pq.size();
        int[] ans = new int[size - 1];
        int idx = 0;
        while (size != 0) {
            Pair top = pq.remove();
            ans[idx++] = top.ele;
            size--;
        }

        return ans;
    }
}

