package July;

import java.util.Arrays;


public class A_sixth2026 {

    public static void main(String[] args) {


        int[][] arr = {{1, 4}, {3, 6}, {2, 8}};

        System.out.println(removeCoveredIntervals(arr));

    }

    public static int removeCoveredIntervals(int[][] intervals) {
        // we sorted it like the meetings conducted question ( if equal in the descending order )
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        // jitna end  points utna count ==  utna answer
        int count = 0;
        int maxend = 0;

        for (int[] interval : intervals) {

            if (interval[1] > maxend) { // if the interval have the max end time update from the another interval  end time
                count++;
                maxend = interval[1];
            }
        }
        return count;
    }

}
