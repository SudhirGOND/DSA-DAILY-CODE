
//import java.util.*;
//
//
//public class MERGE_SORT {
//
//
//    public static void main(String[] args) {
//        int arr1[] = {10, 23, 60, 50, 45, 120, 74, 56};
//
//        int arr2[] = {30, 40, 65, 80, 110, 90};
//
//        Arrays.sort(arr1); //sorting the first array
//        Arrays.sort(arr2); // sorting the 2nd array
//        int arr[] = new int[arr1.length + arr2.length];
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i< arr1.length && j< arr2.length) {
//            //dono mei se loop ko dekhke chalega:::
//
//            if (arr1[i] <= arr2[j]) {
//                arr[k++] = arr1[i++];
//
//            } else arr[k++] = arr2[j++];
//
//        } //remaining elements of the arr1
//            while(i < arr1.length) arr[k++] = arr1[i++];
//            while(j < arr2.length) arr[k++] = arr2[j++];
//
//
//        System.out.println(Arrays.toString(arr));
//
//    }
//
//
//    public static void main(String[] args) {
//
//        int []arr = {10, 23, 60, 50, 45, 120, 74, 56};
//
//        mergesort(arr);
//
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//
//
//    }
//
//    private static void mergesort(int[] arr) {
//        int n = arr.length;
//
//        // addha - aadha mein thod diya...
//
//        if (n == 1) return;
//        int []a = new int[n / 2];
//        int []b = new int[n - n / 2]; //for maintaining the odd number size array
//
//
//        for (int i = 0; i < a.length; i++) a[i] = arr[i];
//        for (int j = 0; j < b.length; j++) b[j] = arr[n / 2 + j];
//
//        /// phir adha k merge krr denga
//        mergesort(a);
//        mergesort(b);
//        //phir dono sorted ho gye honge to add krr do
//        MIXSORTED(a, b, arr);
//
//    }
//
//    private static void MIXSORTED(int arr1[], int arr2[], int arr[]) {
//
//
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i < arr1.length && j < arr2.length) {
//            //dono mei se loop ko dekhke chalega...
//
//            if (arr1[i] <= arr2[j]) {
//                arr[k++] = arr1[i++];
//
//            } else arr[k++] = arr2[j++];
//
//        } //remaining elements of the arr1
//        while (i < arr1.length) arr[k++] = arr1[i++];
//        while (j < arr2.length) arr[k++] = arr2[j++];
//    }
//
//
//}



//count the inversions pairs as in an array  i < j and arr[i] > arr[j]


//public class MERGE_SORT {
//
//
//    static int count;
//
//    static int inversionCount(int arr[]) {
//        count = 0;          // FIX 1: reset count
//        mergesort(arr);
//        return count;
//    }
//
//    private static void mergesort(int[] arr) {
//        int n = arr.length;
//
//        if (n <= 1)         // FIX 2
//            return;
//
//        int a[] = new int[n / 2];
//        int b[] = new int[n - n / 2];
//
//        for (int i = 0; i < a.length; i++)
//            a[i] = arr[i];
//        for (int j = 0; j < b.length; j++)
//            b[j] = arr[n / 2 + j];
//
//        mergesort(a);
//        mergesort(b);
//
//        MIXSORTED(a, b, arr);
//    }
//
//    private static void MIXSORTED(int arr1[], int arr2[], int arr[]) {
//
//        int i = 0, j = 0, k = 0;
//
//        while (i < arr1.length && j < arr2.length) {
//            if (arr1[i] <= arr2[j]) {
//                arr[k++] = arr1[i++];
//            } else {
//                count += (arr1.length - i);  // correct inversion logic
//                arr[k++] = arr2[j++];
//            }
//        }
//
//        while (i < arr1.length)
//            arr[k++] = arr1[i++];

//        while (j < arr2.length)
//            arr[k++] = arr2[j++];
//    }
//}
//
//


//recursive function for the merge sort like binary search

//
//import java.util.Arrays;
//
//public class MERGE_SORT {
//    public static void main(String[] args) {
//        int[] arr = {2, 5, 4, 3, 1};
//        int low = 0;
//        int high = arr.length - 1;
//        mergeSort(arr, low, high);
//        System.out.println(Arrays.toString(arr));
//    }
//
//    private static void mergeSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int mid = low + (high - low) / 2;
//            mergeSort(arr, low, mid);//left
//            mergeSort(arr, mid + 1, high);//right array
//            merge(arr, low, high, mid);
//        }
//    }
//
//    private static void merge(int[] arr, int low, int high, int mid) {
//        int[] brr = new int[high - low + 1];
//        int i = low;
//        int j = mid + 1;
//        int k = 0;
//        while (i <= mid && j <= high) {
//            if (arr[i] <= arr[j]) {
//                brr[k++] = arr[i++];
//            } else
//                brr[k++] = arr[j++];
//        }
//        //left over elements of the respective arrays
//        while (i <= mid) brr[k++] = arr[i++];
//        while (j <= high) brr[k++] = arr[j++];
//
//        for (int p = 0; p < brr.length;p++) {
//            arr[low+ p] = brr[p];
//        }
//System.arraycopy(brr,0,arr,low,brr.length);
//
//    }
//}
