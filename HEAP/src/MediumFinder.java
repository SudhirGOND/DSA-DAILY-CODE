//import java.util.ArrayList;
//import java.util.Collections;
//
//class MedianFinder {
//    ArrayList<Integer> arr;
//
//    public MedianFinder() {
//        arr = new ArrayList<>();// made the array to store the data stream
//    }
//
//    public void addNum(int num) {
//        arr.add(num);
//    }
//
//    public double findMedian() {
//        Collections.sort(arr);
//        int n = arr.size();
//        if (n % 2 == 1) return arr.get(n / 2);
//        else return (arr.get(n / 2) + arr.get(n / 2 - 1)) / 2.0;
//
//    }
//}

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap  =  new PriorityQueue<>();/// min element of the right side of the medium
    PriorityQueue<Integer> maxHeap  =  new PriorityQueue<>(Collections.reverseOrder());/// max ele of the left side of the medium
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Rebalance (only one move ever needed)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}




