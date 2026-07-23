package July;

public class G_NineteenthJuly2026 {


    /// givent the string -->  bcabc ==> " abc"
    public String smallestSubsequence(String s) {

        int n = s.length();

        int[] lastindex = new int[26]; //  a  ->  z letter only (index )
        // count the last index

        for (int i = 0; i < s.length(); i++) {
            lastindex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited;

        visited = new boolean[26];
        ///  stores the visited ( replaced it by the stack als0)

        StringBuilder result;
        result = new StringBuilder();


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (visited[idx]) continue; ///skip the old character
            while (!result.isEmpty() && result.charAt(result.length() - 1) > ch && i < lastindex[result.charAt(result.length() - 1) - 'a']) {

                visited[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            visited[idx] = true;

        }

        return result.toString();

    }
}
