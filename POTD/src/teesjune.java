public class teesjune {


    public static void main(String[] args) {
        numberOfSubstrings("abcabc");
    }

//this solution gives the TLE of the code submitted
//    static void numberOfSubstrings(String s) {
//        int ans = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int acount = 0;
//            int bcount = 0;
//            int ccount = 0;
//            for (int j = i; j < s.length(); j++) {
//
//                if (s.charAt(j) == 'a')
//                    acount++;
//                if (s.charAt(j) == 'b')
//                    bcount++;
//                if (s.charAt(j) == 'c')
//                    ccount++;
//
//                if (acount > 0 && bcount > 0 && ccount > 0) {
//                    ans++;
//                }
//            }
//
//        }
//
//    }


    /// now the sliding window example
    ///


    static void numberOfSubstrings(String s) {


        int n = s.length();
        int[] freq = new int[3]; //// we know that it have only 3 lettersi
        int i = 0;
        int j = 0;
        int count = 0; ////  count the substring which have the at least abc one time occured
        while (j < n) {
            char ch = s.charAt(j);
            freq[ch - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                count += n - j;
                freq[s.charAt(i) - 'a']--; //// freq of last character reduced by 1

                i++;
            }
            j++;

        }
        System.out.println(count);
    }
}
