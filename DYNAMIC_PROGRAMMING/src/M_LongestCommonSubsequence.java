import java.util.Arrays;

public class M_LongestCommonSubsequence {


    public static void main(String[] args) {

//        System.out.println("Longest Subsequence Length = " + count("asdf", "aergesftyjdtyfg"));

        String a = "asdf";
        String b = "aergesftyjdtyfg";


//        System.out.println("Longest Subsequence Length = " + countIndexversion(a.length() - 1, b.length() - 1, a, b));

        ////note the 2 variable travel (  j -1 --> 0 ,  i-1 --> 0)
        StringBuilder s  =  new StringBuilder(a);
        StringBuilder t  =  new StringBuilder(b);
        int i = a.length();
        int j = b.length();
        int dp[][] = new int[i][j];

        for (int I = 0; I < i; I++) {
            Arrays.fill(dp[I], -1);
        }
        System.out.println(" the lcs  : = " + countdp(i-1, j-1, s, t, dp));
    }

    private static int count(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < 1 || n < 1) return 0;
        String a = text1.substring(0, m - 1);
        String b = text2.substring(0, n - 1);


        if (text1.charAt(m - 1) == text2.charAt(n - 1))
            return 1 + count(a, b);

        else
            return Math.max(count(text1, b), count(a, text2));


    }


    private static int countIndexversion(int i, int j, String a, String b) {

        if (i < 0 || j < 0) return 0;


        if (a.charAt(i) == b.charAt(j))
            return 1 + countIndexversion(i - 1, j - 1, a, b);

        else
            return Math.max(countIndexversion(i - 1, j, a, b), countIndexversion(i, j - 1, a, b));


    }



    private static int countdp(int i, int j, StringBuilder a, StringBuilder b, int dp[][]) {

        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i) == b.charAt(j))
            return dp[i][j] = 1 + countdp(i - 1, j - 1, a, b,dp);

        else
            return dp[i][j] = Math.max(countdp(i - 1, j, a, b,dp), countdp(i, j - 1, a, b,dp));


    }



}


