import java.util.ArrayList;
import java.util.List;

public class G_InsertIntervals {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        //N0 overlapping before merging the intervals
        while (i < n && newInterval[0] > intervals[i][1]) { //  endtime < startime(new)
            ans.add(intervals[i]); /// adding the 1d array
            i++;
        }

        /// oveerlapping ans merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {// endtime(new) >  startime (old)

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;

        }

        ans.add(newInterval);

        // wno overlapping after merging

        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        ///// main thing is that

        //convert the list to array

        return ans.toArray(new int[ans.size()][]);
    }
}

