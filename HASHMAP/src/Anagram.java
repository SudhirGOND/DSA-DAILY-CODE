import java.util.HashMap;

public class Anagram {
    public static boolean AnagramValid(String s, String t) {
        s = "silent";
        t = "listen";
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) return false; ////  wo element hi nhi to not anagram = false

            int freq = map.get(ch);
            if (freq == 0) return false;

            map.put(ch, freq - 1);


        }

        return true;
    }


}
