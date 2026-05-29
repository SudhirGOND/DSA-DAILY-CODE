public class ScoreFlipThematrix {


    public int matrixScore(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        /// 0th col of matrix should have all ones

        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {  //  flip the row leftmost bit (first column) is the most significant bit (MSB) — it contributes the largest value.
                for (int j = 0; j < n; j++) {
                    arr[i][j] ^= 1;
                    // arr[i][j] = 1 - arr[i][j];


                }

            }
        }
        /// har us col ko flip karo jisme  no of 0 >  no of 1

        for (int j = 0; j < n; j++) {
            int zeros = 0;
            int ones = 0;

            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 0) zeros++; ///  counting the zeros
                else ones++;  ////  counting the ones
            }
            if (zeros > ones) { // flip that col
                for (int i = 0; i < m; i++) {
                    arr[i][j] ^= 1;
                }
            }

        }

        int sum = 0;
        int pow = 1;

        for (int j = n - 1; j >= 0; j--) {
            // Loop over columns from rightmost (least significant bit) to leftmost

            int ones = 0;
            // Counter to store how many 1s are present in the current column

            for (int i = 0; i < m; i++) {
                // Iterate over all rows for the current column

                if (arr[i][j] == 1) ones++;
                // If the current cell is 1, increment the count of ones
            }

            sum += pow * ones;
            // Add contribution of this column to total sum:
            // each '1' contributes 'pow' (current column's binary weight)

            pow *= 2;
            // Move to the next higher binary weight (e.g., 1 → 2 → 4 → 8 ...)
        }
        return sum;


    }
}
