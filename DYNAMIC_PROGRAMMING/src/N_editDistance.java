public class N_editDistance {
    public static void main(String[] args) {

        minDistance("horse", "ors");
        System.out.println(minDistanceTABU("horse", "ors"));

    }

    public static void minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();

        /// 3 kaamm bss krna hain
        //// delete , insert , replaced
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);


        System.out.println("Min steps to edit " + minstep(i - 1, j - 1, a, b));


    }

    private static int minstep(int i, int j, StringBuilder a, StringBuilder b) {


        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (a.charAt(i) == b.charAt(j)) return minstep(i - 1, j - 1, a, b);
        else {
            int del = minstep(i - 1, j, a, b);
            int ins = minstep(i, j - 1, a, b);
            int rep = minstep(i - 1, j - 1, a, b);


            return 1 + Math.min(del, Math.min(ins, rep));
        }

    }


    public static int minDistanceTABU(String a, String b) {
        int m = a.length();
        int n = b.length();

        /// 3 kaamm bss krna hain delete , insert , replaced
        //now the 00   -->   i -1  // j -1  -->  0
        int dp[][] = new int[m + 1][n + 1];
        ////filll the 1 row and the column

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int del = dp[i - 1][j];
                    int ins = dp[i][j - 1];
                    int rep = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(del, Math.min(ins, rep));
                }

            }

        }

        return dp[m][n];

    }


}
