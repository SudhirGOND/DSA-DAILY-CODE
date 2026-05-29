//class Heap {
//
//    int[] arr;
//    int size = 0; // better than idx confusion
//
//    Heap(int capacity) {
//        arr = new int[capacity + 1]; // 1-based indexing
//    }
//
//    // return minimum element
//    int peek() {
//        if (size == 0) {
//            System.out.println("heap is empty");
//            return -1;
//        }
//        return arr[1];
//    }
//
//    // insert element (optimized heapify up)
//    void add(int ele) {
//        arr[++size] = ele;
//
//        int i = size;
//
//        // heapify up (no extra variables, minimal swaps)
//        while (i > 1 && arr[i] < arr[i / 2]) {
//            swap(i, i / 2);
//            i = i / 2;
//        }
//    }
//
//    // remove min (optimized heapify down)
//    int remove() {
//        if (size == 0) {
//            System.out.println("heap is empty");
//            return -1;
//        }
//
//        int min = arr[1];
//
//        // move last to root
//        arr[1] = arr[size--];
//
//        int i = 1;
//
//        // heapify down (only compare necessary nodes)
//        while (2 * i <= size) {
//            int left = 2 * i;
//            int right = left + 1;
//
//            int smallest = left;
//
//            // check right child only if exists
//            if (right <= size && arr[right] < arr[left]) {
//                smallest = right;
//            }
//
//            // if already correct → stop early
//            if (arr[i] <= arr[smallest]) break;
//
//            swap(i, smallest);
//            i = smallest;
//        }
//
//        return min;
//    }
//
//    // swap helper → avoids repeating code
//    void swap(int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    void display() {
//        for (int i = 1; i <= size; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//}
//
//
//class ImplementationofMinHeap {
//
//    public static void main(String[] args) {
//
//        Heap h = new Heap(10);
//
//        // adding elements
//        h.add(10);
//        h.add(5);
//        h.add(20);
//        h.add(2);
//        h.add(8);
//
//        System.out.print("Heap elements: ");
//        h.display();
//
//        System.out.println("Peek: " + h.peek());
//
//        System.out.println("Removed: " + h.remove());
//
//        System.out.print("Heap after removal: ");
//        h.display();
//        h.add(23);
//        h.display();
//        h.remove();
//        h.display();
//    }
//}