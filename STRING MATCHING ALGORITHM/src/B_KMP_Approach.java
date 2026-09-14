/**
 1. Compare the string and pattern character by character.
 2. If characters match → move both pointers forward.
 3. If a mismatch occurs → don’t start over from the beginning.
 4. Use the LPS array to know how far the pattern can safely jump.
 5. LPS tells us the longest prefix that is also a suffix.
 6. This avoids rechecking characters that have already matched.
 7. Therefore, KMP searches in O(n + m) time.

//LPS ARRAY KO FILL KAISE KARE
 LPS ka matlab: Longest Proper Prefix which is also Suffix.
 Har position par hum check karte hain: “Ab tak ke pattern mein starting ka kitna part ending mein bhi same hai?”
 Jo maximum matching length milti hai, wahi LPS value hai.
 Iska use KMP mein mismatch ke baad pattern ko unnecessarily restart hone se bachane ke liye hota hai.
 Agar LPS[i] = k, iska matlab: first k characters = last k characters.
**/



public class B_KMP_Approach {

    public static void main(String[] args) {

        String str = "abababba";
        String pattern = "aba";

        int n = str.length();
        int m = pattern.length();

        if (m > n) {
            System.out.println("Pattern is longer than the string");
            return;
        }

        // Create LPS array
        int[] lps = new int[m];

        computeLPS(pattern, lps);

        // KMP searching
        int i = 0; // index for string
        int j = 0; // index for pattern

        while (i < n) {

            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index: " + (i - j));

                // Continue searching for next occurrence
                j = lps[j - 1];

            } else if (i < n && str.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }


    // Function to create LPS array
    public static void computeLPS(String pattern, int[] lps) {

        int length = 0;
        int i = 1;

        lps[0] = 0;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
