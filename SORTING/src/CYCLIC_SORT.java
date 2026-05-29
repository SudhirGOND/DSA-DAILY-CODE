//
//
//public class CYCLE_SORT{
//
//public static void main(String[] args) {
//
//
//
//int[] arr = { 3, 2, 4, 5, 1 };
//int n = arr.length;
//        System.out.println("Before sort :");
//        System.out.println(Arrays.toString(arr));
//CycleSort(arr, n);
//
//
//    }
//
//static void CycleSort(int[] arr, int n)
//{
//    int i = 0;
//    while (i < n) {
//        // as array is of 1 based indexing so the
//        // correct position or index number of each
//        // element is element-1 i.e. 1 will be at 0th
//        // index similarly 2 correct index will 1 so
//        // on...
//        int correctpos = arr[i] - 1;
//        if (arr[i] < n && arr[i] != arr[correctpos]) {
//            // if array element should be lesser than
//            // size and array element should not be at
//            // its correct position then only swap with
//            // its correct position or index value
//            swap(arr, i, correctpos);
//        }
//        else {
//            // if element is at its correct position
//            // just increment i and check for remaining
//            // array elements
//            i++;
//        }
//    }
//    System.out.println("After sort :  ");
//    System.out.print(Arrays.toString(arr));
//
//
//}
//
//static void swap(int[] arr, int i, int correctpos)
//{
//    // swap elements with their correct indexes
//    int temp = arr[i];
//    arr[i] = arr[correctpos];
//    arr[correctpos] = temp;
//}
//
//}


///  Missing number using the cyclic sort
/// 1 .. sbse phle element ko index se compare krke
/// 2... phir usko swapping krte haini using the swap function
/// 3.. new loop se traverese krke pta lagate hain ki idx se arr element kaha match nhi krr rha
/// 4.. jaha nhi kkrkr rha vahi elemt return krr do .. duplicate hai
/// 5.... for the missing return the index as in thor form of i;;;

import java.util.*;

public class CYCLIC_SORT {


    /// question is -->
    ///
    /// You are given an array arr[] of size n - 1 that contains distinct integers
    /// in the range from 1 to n (inclusive). This array represents a permutation
    /// of the integers from 1 to n with one element missing. Your task is to identify
    /// and return the missing element.


    public static void main(String[] args)


    //it is applicable for the [1 to N]
    // TC IS THE O(n) and SC =O(1)

    {
        int[] arr = {3, 2,3, 4, 5, 1};/// for the missing number //duyplicae

//        int n = arr.length + 1;//for finding the missing that can be at last
        int n = arr.length ;//for finding the duplicate
        System.out.println("Before sort :");
        System.out.println(Arrays.toString(arr));
        CycleSort(arr, n);


    }

    private static void CycleSort(int[] arr, int n) {
        int i = 0;
        while (i < arr.length) {
            // as array is of 1 based indexing so the
            // correct position or index number of each
            // element is element-1 i.e. 1 will be at 0th
            // index similarly 2 correct index will 1 so
            // on...
            int correctpos = arr[i] - 1;
            if (arr[i] < n && arr[i] != arr[correctpos]) {
                // if array element should be lesser than
                // size and array element should not be at
                // its correct position then only swap with
                // its correct position or index value
                swap(arr, i, correctpos);
            } else {
                // if element is at its correct position
                // just increment i and check for remaining
                // array elements
                i++;
            }
        }
        ///for finding the missing number
//        for (int j = 0; j < arr.length; j++) {
//            if (arr[j] != j + 1) {
//                System.out.println(j + 1);
//            }
//
//        }
        /// for finding the duplicate number
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                System.out.println(arr[j]);
            }

        }


        System.out.println("After sort :  ");
        System.out.print(Arrays.toString(arr));


    }

    private static void swap(int[] arr, int i, int correctpos) {
        // swap elements with their correct indexes
        int temp = arr[i];
        arr[i] = arr[correctpos];
        arr[correctpos] = temp;
    }


}
