import java.util.Arrays;

public class F_Non_OverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        /// sortinmg the arrays accorting to the end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int endtime = Integer.MIN_VALUE;
        int count = 0;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (endtime <= intervals[i][0]) {
                count++;
                endtime = intervals[i][1];
            }
        }

        return n - count;

    }
}
