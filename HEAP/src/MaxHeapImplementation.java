
class MaxHeap {
    int arr[];
    int size = 0;

    MaxHeap(int capacity) {
        arr = new int[capacity + 1]; //  1 based indexing
    }

    int peek() {

        if (size == 0) {
            System.out.println("heap is empty!!");
            return Integer.MIN_VALUE;
        }
        return arr[1]; ///  the top-most element from the heap

    }

    /// / insertion of the ele
    void add(int ele) {
        if (size == arr.length - 1) {
            System.out.println("Heap is full!");
            return;
        }
        arr[++size] = ele;
        int i = size;

        /// heapify and the rearrangement will take place
        while (i > 1 && arr[i] > arr[i / 2]) {

            swap(i, i / 2);
            i = i / 2;
        }

    }

    int remove() {

        // Step 1: Check if heap is empty
        // If no elements exist, return a minimum value (error indicator)
        if (size == 0) {
            System.out.println("Heap is empty!!");
            return Integer.MIN_VALUE;
        }

        // Step 2: Store the root element (maximum in max-heap)
        int removed = arr[1];

        // Step 3: Move the last element in the heap to the root position
        // This temporarily breaks the heap property
        arr[1] = arr[size];

        // Step 4: Reduce heap size (effectively removing last element)
        size--;

        // Step 5: Start heapify-down process from root
        int i = 1;

        // Step 6: Continue while current node has at least one child
        while (2 * i <= size) {

            // Step 6.1: Identify left and right child indices
            int left = 2 * i;
            int right = 2 * i + 1;

            // Step 6.2: Assume current node is largest
            int largest = i;

            // Step 6.3: Compare with left child
            // If left child is bigger, update largest
            if (left <= size && arr[left] > arr[largest]) {
                largest = left;
            }

            // Step 6.4: Compare with right child
            // If right child is bigger than current largest, update
            if (right <= size && arr[right] > arr[largest]) {
                largest = right;
            }

            // Step 6.5: If largest is not the current node,
            // swap and continue heapifying down
            if (largest != i) {
                swap(i, largest);

                // Move index to where we swapped
                i = largest;
            } else {
                // Step 6.6: If no swap needed, heap property is restored
                break;
            }
        }

        // Step 7: Return the removed maximum element
        return removed;
    }




    // swap helper → avoids repeating code
    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


public class MaxHeapImplementation {


    public static void main(String[] args) {

        MaxHeap h = new MaxHeap(10);

        // adding elements
        h.add(10);
        h.add(5);
        h.add(20);
        h.add(2);
        h.add(8);

        System.out.print("Heap elements: ");
        h.display();
        h.add(23);
        System.out.println("Peek: " + h.peek());

        System.out.println("Removed: " + h.remove());

        System.out.print("Heap after removal: ");
        h.display();

        h.remove();
        h.display();
    }


}
