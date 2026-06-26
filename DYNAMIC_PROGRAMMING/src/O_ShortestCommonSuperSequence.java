public class O_ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";

        superseqeuence(a, b);
    }

    public static String LCS(String a, String b) {

        int m = a.length();
        int n = b.length();

        if (m == 0 || n == 0) return "";
        //// m-1  -->   0 and the n-1  -->  0
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                }
            }

        }///we are going top construct the String LCS

        StringBuilder ans = new StringBuilder("");
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));

                i--;
                j--;

            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
        ans.reverse(); /// reverse the appended StringBuilder


        return ans.toString();

    }


    public static String superseqeuence(String a, String b) {

        String lcs = LCS(a, b);
        ////System.out.println(lcs);
        StringBuilder scs = new StringBuilder(""); /// we will make out string supersequence
        /// so we merge the all  the remaining letter from the 2 string
        int i = 0;/// for str1
        int j = 0;/// for str2
        int k = 0;/// for lcs

        while (k < lcs.length()) {


            while (a.charAt(i) != lcs.charAt(k)) {
                scs.append(a.charAt(i));
                i++;
            }
            while (b.charAt(j) != lcs.charAt(k)) {
                scs.append(b.charAt(j));
                j++;
            }

            scs.append(lcs.charAt(k));
            i++;
            j++;
            k++;  /// ess time to baraber hoga


        }

        /// noow the left element
        while(i < a.length()){
            scs.append(a.charAt(i++));
        }
        while(j < b.length()){
            scs.append(b.charAt(j++));
        }
        System.out.println(scs);
        return scs.toString();

    }


}