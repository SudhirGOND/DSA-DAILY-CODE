import java.util.ArrayList;
import java.util.PriorityQueue;

public class C_job_scheduling {


    public static void main(String[] args) {

        int deaddline[] = {};
        int profit[] = {};
        System.out.println(jobSequencing(deaddline, profit));

    }


    public static ArrayList<Integer> jobSequencing(int[] dead, int[] pro) {

        int n = dead.length;

        // Store {deadline, profit}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{dead[i], pro[i]});
        }

        // Find maximum deadline
        int maxDeadline = 0;

        for (int d : dead) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // 0 = free slot
        int[] slot = new int[maxDeadline + 1];
        /// now fill the array withe index numbers
        for (int i = 0; i < slot.length; i++) {
            slot[i] = i;
        }

        int count = 0;
        int profit = 0;

        while (!pq.isEmpty()) {

            int[] job = pq.poll();

            int deadline = job[0];
            int currProfit = job[1];
            //// find the slot

            int gap = findslot(deadline, slot);
            if (gap > 0) {
                count++;
                profit += currProfit;
                slot[gap] = gap - 1; /// sllot mein 1 phle index ka gap / value daal denge
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(count);
        ans.add(profit);

        return ans;
    }

    // this is the recursive function

    public static int findslot(int deadline, int[] slot) {

        if (deadline == slot[deadline])
            return deadline;

        return slot[deadline] = findslot(slot[deadline], slot);
    }

}


