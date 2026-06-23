public class N_editDistance {
    public static void main(String[] args) {

        minDistance("horse", "ors");
    }

    public static void minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();

        /// 3 kaamm bss krna hain
        //// delete , insert , replaced
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);


        System.out.println("Min steps to edit " + minstep(i - 1, j - 1, a, b));


    }

    private static int minstep(int i, int j, StringBuilder a, StringBuilder b) {

        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (a.charAt(i) == b.charAt(j)) return minstep(i - 1, j - 1, a, b);
        else {
            int del = minstep(i - 1, j, a, b);
            int ins = minstep(i, j - 1, a, b);
            int rep = minstep(i-1, j-1, a, b);


            return 1 + Math.min(del, Math.min(ins, rep));
        }

    }


}
