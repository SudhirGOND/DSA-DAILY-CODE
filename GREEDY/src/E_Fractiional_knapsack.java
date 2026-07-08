import java.util.Arrays;

public class E_Fractiional_knapsack {


    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = wt.length;

        double[][] item = new double[n][3];

        // item[i][0] = value
        // item[i][1] = weight
        // item[i][2] = value/weight ratio
        for (int i = 0; i < n; i++) {
            item[i][0] = val[i];
            item[i][1] = wt[i];
            item[i][2] = (double) val[i] / wt[i];
        }

        // Sort in descending order of value/weight ratio
        Arrays.sort(item, (a, b) -> Double.compare(b[2], a[2]));

        double profit = 0.0;
        int i = 0;

        while (i < n && capacity > 0) {

            // Take the whole item
            if (capacity >= item[i][1]) {
                profit += item[i][0];
                capacity -= item[i][1];
            }
            // Take a fraction of the item
            else {
                profit += capacity * item[i][2];
                capacity = 0;
            }

            i++;
        }

        return profit;
    }
}

