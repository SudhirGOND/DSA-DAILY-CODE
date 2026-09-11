public class D_CountUniqueSubstring {
    static class Node {


        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            // alloting the memory
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;

        }

    }


    static Node root = new Node(); // this is always khali

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


    public static void main(String[] args) {

        String str = "ababa";
        //insert all suffixes to Trie

        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }


        System.out.println(countNodes(root));

    }


    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }


        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return 1 + count; //extra one for the self node


    }
}
