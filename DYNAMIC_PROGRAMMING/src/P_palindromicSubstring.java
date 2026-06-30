public class P_palindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n][n]; /// we made the dp n X n
        // we need the upper parrt to fill thee dp forthe reusedof the palindrome result

        String str = ""; // / palindrome
        int ans = 0;
        for (int k = 0; k < n; k++) { /// 0 --> n-1 upper part half middle
            int i = 0;
            int j = k;

            while (j < n) {//// for the 1 length
                if (i == j)   {
                    dp[i][j] = 1;
                    ans = Math.max(ans, 1);
                    if (str.length() < ans) {
                        str = s.substring(i, j + 1);
                    }

                } else if (j == i + 1) //  for the 2 length
                {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        ans = Math.max(ans, 2);
                        if (str.length() < ans) {
                            str = s.substring(i, j + 1);
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] == 1) {
                            dp[i][j] = 1;
                            ans = Math.max(ans, j - i + 1);
                            if (str.length() <= ans) {
                                str = s.substring(i, j + 1);
                            }
                        }
                    }
                }

                i++;
                j++;
            }
        }
        System.out.println(str);

        return str;
    }


}


