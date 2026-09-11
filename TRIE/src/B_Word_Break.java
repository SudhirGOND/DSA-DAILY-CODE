public class B_Word_Break {


    public static boolean wordBreak(String key) {
        if (key.isEmpty()) return true;
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            if (A_Trie_Implementation.search(firstPart) && wordBreak(secondPart)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String[] words = {"i", "like", "samsung", "sam", "mobile"};
        String key = "ilikesamsung";

        for (int i = 0; i < words.length; i++) {
            A_Trie_Implementation.insert(words[i]);
        }


        System.out.println(wordBreak(key));

    }
}
