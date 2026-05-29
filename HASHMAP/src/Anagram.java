//import java.util.HashMap;
//
//public class Anagram {
//    public static boolean AnagramValid(String s, String t) {
//        s = "silent";
//        t = "listen";
//        if (s.length() != t.length()) return false;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//
//        }
//
//        for (char ch : t.toCharArray()) {
//            if (!map.containsKey(ch)) return false; ////  wo element hi nhi to not anagram = false
//
//            int freq = map.get(ch);
//            if (freq == 0) return false;
//
//            map.put(ch, freq - 1);
//
//        }
//
//        return true;
//    }
//
//
//}


import java.util.HashMap;

public class Anagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }
            int freq  =  map.get(ch);
            map.put(ch,freq- 1);/// remove the elements

            if (freq == 0) {
                map.remove(ch); /// remove the element from the map
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("silent", "listen"));
    }
}
