/**
 * Brute force se Greedy tak kaise sochen?
 * Ab apne aap se 3 questions poochho:
 * 1. Kya har job ko select karna zaroori hai? Nahi.
 * 2. Kya har job ka profit same hai? Nahi.
 * 3. Kya hum high-profit job ko pehle consider kar sakte hain aur uske liye feasible slot find kar sakte hain? Haan.
 * Yahi greedy intuition hai.
 * <p>
 * Greedy rule:
 * 1. Jobs ko profit ke descending order mein sort karo.
 * 2. Har job ke liye uski deadline se lekar slot 1 tak peeche search karo.
 * 3. Jo sabse late empty slot mile, usmein job schedule karo.
 * 4. Koi slot na mile, toh job skip kar do.
 */



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


