import java.util.Arrays;

public class B_N_MettingInRoom {
//    /// /Activity selection on the gfg

    public int activitySelection(int[] start, int[] end) {

        int n = start.length;

        // meetings[i][0] = start time
        // meetings[i][1] = end time
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort meetings according to their ending time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = -1;

        for (int[] meeting : meetings) {

            if (meeting[0] > lastEnd) {
                count++;
                lastEnd = meeting[1];
            }
        }

        return count;
    }
}


