
/**
 * // Going to solve the question that is based on the case Based Study
 *
 * //        Airport security officials have confiscated several item of the passengers at the
 * //        security check point. All the items
 * //        have been dumped into a huge box (array). Each item possesses a certain amount of
 * //        risk[0,1,2]. Here, the risk severity of
 * //        the items represent an array[] of N number of integer values. The task here is to sort the
 * //        items based on their levels of
 * //        risk in the array. The risk values range from 0 to 2.
 * //        Example:
 * //        Input:
 * //        7 -> Value of N
 * //        [1,0,2,0,1,0,2]-> Element of arr[0] to arr[N-1], while input each element is separated by
 **/

/// -->  the simple code is that we have to SORT THE ARRAY THAT HAVE ONLY 3 ELEMENTS (DUTCH FLAG ALGORITHM && SORT  THE COLORS )
///
/// ==> import library is prohibited
/// Arrays.sort(array);
///
///
///
/// the first question of the TCS video

import java.util.*;

public class A_AirportSecurity {


    public static void main(String[] args) {


        int[] arr = {1, 0, 1, 1, 0, 1, 2, 2, 0, 1, 0, 1, 2};

        /// ******** logic 1 is **********///
        /// Count the No. of zeros, One and Two's
        /// Then made the new ARRAY fill it according to the couunting
        /// ITS T.C IS O(N) // S.c -> O(n)

        ///********************** logic 2 --> Dutch algorithm **************///
        /// 0 -->  low -1  --> == 0
        /// low -->  mid  -1 --> == 1
        /// high +1 --> last ele  ==  2
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (mid <= high) {


            if (arr[mid] == 0) {

                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;

            } else if (arr[mid] == 1) mid++;
            else {

                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;

            }


        }
        System.out.println(Arrays.toString(arr));

    }


}
