//import java.util.HashMap;
//
//public class MostFrequenceChar {
//
//
//    public char getMaxOccurring(String s) {
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        ///PUTTING THE PAIR OF THE CHAR AND THE FREQ
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (map.containsKey(ch)) {
//                int freq = map.get(ch); /// checking the Freq
//                map.put(ch, freq + 1);
//            } else map.put(ch, 1);
//        }
//
//        //// FINDING THE MAX FREQ
//        int maxFreq = 0;
//        for (char ch : map.keySet()) {
//            int freq = map.get(ch);
//            if (freq > maxFreq) maxFreq = freq;
//        }
//        ///FINDING THE CHAR AT MAX FREQ
//
//        char ans = 'z';////example ke taur pe kuch bhi maxi letter ch
//        for (char ch : map.keySet()) {
//            int freq = map.get(ch);
//            if (freq == maxFreq && ch <= ans) {
//                ans = ch;
//            }
//        }
//        return ans;
//    }
//
//
//}
//

public class MostFrequenceChar {

    public char getMaxOccuringChar(String s) {

        // Frequency array for all ASCII characters
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch]++; //  freq[ch] = freq[ch] + 1;
        }

        // Find character with maximum frequency
        char ans = 0;
        int maxFreq = 0;

        for (int i = 0; i < 256; i++) {

            // Update only if frequency is greater
            // OR same frequency but smaller character
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = (char) i;
            }
        }

        return ans;
    }
}
