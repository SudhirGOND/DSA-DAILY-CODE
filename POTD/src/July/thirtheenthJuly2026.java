package July;

import java.util.ArrayList;
import java.util.List;

public class thirtheenthJuly2026 {

    public static void main(String[] args) {

        sequentialDigits(100, 130);
    }


    public static List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> ans = new ArrayList<>();
//
//        for (int i = low; i <= high; i++) {
//            if (sequential(i)) {
//                ans.add(i);
//            }
//        }
//        System.out.println(ans);
//        return ans;


        List<Integer> ans = new ArrayList<>();

        /// now wer check that form 1 to 9 within [low-high] sequential
        //

        for (int i = 1; i <= 9; i++) {

            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;

                if (low <= num && high >= num) {
                    ans.add(num);
                }
            }

        }
        System.out.println(ans);
        return ans;
    }

//    public static boolean sequential(int num) {
//        //// how to iterate to the INTEGER
//
//        String str = String.valueOf(num);
//        char[] arr = str.toCharArray();
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] + 1 != arr[i + 1]) {
//                return false;
//            }
//
//        }
//        return true;
//
//    }


}
