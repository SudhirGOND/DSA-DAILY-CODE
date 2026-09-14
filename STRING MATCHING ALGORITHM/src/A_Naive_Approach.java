public class A_Naive_Approach {

    public static void main(String[] args) {
        String str = "abababba";
        String pattern = "aba";

        search(str, pattern);
    }

    public static void search(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        if (m > n) {
            System.out.println("Invalid Pattern Found");
            return;
        }

        for (int i = 0; i <= n - m; i++) {

            int j;

            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }
}
