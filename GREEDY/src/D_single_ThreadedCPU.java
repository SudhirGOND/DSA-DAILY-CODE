import java.util.Arrays;
import java.util.PriorityQueue;

public class D_single_ThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[] ans = new int[n];
        int extratasks[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            extratasks[i][2] = i; // first
            extratasks[i][1] = tasks[i][1];
            extratasks[i][0] = tasks[i][0];
        }

        /// sort the task -> BY THE ENQUEUE TIME
        Arrays.sort(extratasks, (a, b) -> a[0] - b[0]);

        int timer = extratasks[0][0];
        int i = 0;
        int idx = 0;
        /// put all the tasks into the min heap <= enqueue time
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        while (idx < n) {
            while (i < n && extratasks[i][0] <= timer) {

                pq.add(new int[]{extratasks[i][1], extratasks[i][2]});
                i++;
            }

            // if the min heap is empty
            if (pq.isEmpty()) {
                timer = extratasks[i][0];
            }
            // n0t empty
            else {
                int[] arr = pq.poll();
                ans[idx++] = arr[1];
                timer += arr[0];
            }

        }

        return ans;
    }


}
