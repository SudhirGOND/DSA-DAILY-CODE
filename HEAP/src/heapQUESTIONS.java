import java.util.Collections;
import java.util.PriorityQueue;

public class heapQUESTIONS {

    /// / finding the kth smallest element from the array
//    public static int kth-smallest(int[] arr, int k) {\
//
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int ele : arr) {  ///n*logk
//            pq.add(ele); ///  logk
//            if (pq.size() > k) pq.remove(); // logk
//        }
//        return pq.peek();
//    }


    /// /minimum cost of the rope buying

//    public static int minCost(int[] arr) {
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();// Min heap
//        for (int ele : arr) {
//            pq.add(ele);
//        }
//        int ans =0;
//        while (pq.size() > 1) {
//            int r1 = pq.remove();
//            int r2 = pq.remove();
//            //insertion of the addition
//
//            int insert = r1 + r2;
//            ans  +=  insert;
//            pq.add(insert);
//        }
//        return ans;
//
//    }

    public static void main(String[] args) {

/// Priority queue implementing the min --  heap property
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.add(23);
        pq.add(24);
        pq.add(25);
        pq.add(50);
        pq.add(27);
        pq.add(256);
        pq.add(29);
        pq.add(30);
//        System.out.println(pq.peek());
//        System.out.println(pq.size());
//        System.out.println(pq);
//        while (pq.size() != 0) {
//            System.out.println(pq.remove());
//
//        }
        int arr[] = {2, 4, 6, 7, 9};
//        kthsmallest(arr, 4);
//        System.out.println(minCost(arr));

    }


}