public class E_Longest_Word {

    static class Node {

        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            eow = false;
        }


    }


    static Node root = new Node(); // this is always khaali

    public static void insert(String word) {
        // traverse the word
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {  /** O(L) -->  largest word length **/
            int idx = word.charAt(i) - 'a'; // yaha pe word hain

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true; /// marked as the eow
            }

            curr = curr.children[idx]; /// update the root

        }

    }

    static String ans = "";

    public  static void longestWord(Node root, StringBuilder temp) {

        if (root == null) return;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a')); //// tmeep store the string
                if (temp.length() > ans.length()) {  //lexographically smallest ko add krenge if same lenghgt ka hoga to
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp); /// aage niche jaao

                /// backtracking
                temp.deleteCharAt(temp.length() - 1);
            }
        }


    }

    public static void main(String[] args) {

        root = new Node();
        String[] words = {"a", "app", "ap", "apple", "banana", "apply", "the", "appl"};
        String key = "apple";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }




}
