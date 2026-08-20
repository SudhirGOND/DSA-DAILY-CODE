
import java.util.*;


public class J_Alein_Dictionary {

    public String findOrder(String[] words) {
        /// its time complexit ==  O(N *L) + o(1) -->  the nu,ber of the words and the
        /// making of the graph

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[26];

        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true; //// we checking that it is present  not

            }
        }

        /// building the graph using  the adjacent list

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());
            int j = 0;

            /// first different character

            while (j < len && a.charAt(j) == b.charAt(j))
                j++;

            /// different milte hi check krenge
            /// "abcd"  before "ab"
            if (j == len && a.length() > b.length()) {
                return ""; /// khel khatum in the lexicographical order the shorted word comes pahle
            }

            // if the characters aree different , create ans edge

            if (j < len) {
                int u = a.charAt(j) - 'a';
                int v = b.charAt(j) - 'a';

                /// check for the duplicate edges
                if (!adj.get(u).contains(v)) {
                    adj.get(u).add(v);
                    indegree[v]++;
                }

            }

        }

        /// topological sort

        Queue<Integer> q = new LinkedList<>();

        int totalCharacters = 0;

        for (int i = 0; i < 26; i++) {
            if (present[i]) {
                totalCharacters++;

                if (indegree[i] == 0) {
                    q.offer(i); /// 0  indegree wale ko hi add krenge
                }
            }
        }

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char) ('a' + u)); /// again appending by converting and adding the 'a'

            for (int v : adj.get(u)) {

                indegree[v]--;
                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        /// cycle detected

        if (order.length() != totalCharacters) {
            return "";
        }

        return order.toString();

    }
}



