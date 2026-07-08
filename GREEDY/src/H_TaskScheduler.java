import java.util.HashMap;

public class H_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        // Populate HashMap and update max frequency simultaneously
        for (char c : tasks) {
            int currentFreq = freqMap.getOrDefault(c, 0) + 1;
            freqMap.put(c, currentFreq);

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
            }
        }

        int ans = (maxFreq - 1) * (n + 1);
        int sum = 0;
        for (char ch : freqMap.keySet()) {
            sum += freqMap.get(ch);
            if (maxFreq == freqMap.get(ch))
                ans++;
        }

        return Math.max(ans, sum);
    }
}



