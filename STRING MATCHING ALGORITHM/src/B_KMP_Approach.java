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
