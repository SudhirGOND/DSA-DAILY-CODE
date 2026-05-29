
//import java.util.Arrays;
//
//public class BinarySearch {
//
//
//    public static void main(String[] args) {
//
//        int[] arr = {1, 34, 45, 67, 78, 89, 678};
//        int k = 89;
//
//        int low = 0;//the first index
//        int high = arr.length - 1;
//        while (low <= high) {
//
//            int mid = low + (high - low) / 2;
//
//
//            if (arr[mid] == k) {
//
//                System.out.println("The index of the element  is : " + mid + " is " + arr[mid]);
//                System.out.println(Arrays.toString(arr));//printing thr array as the string array
//                break;
//            }
//            else if (arr[mid] > k) {
//                high = mid - 1;
//            } else
//                low = mid + 1;
//        }
//    }
//
//
//}


//Find the two repeating elements in a given array

//public class BinarySearch {
//
//    public static void print(int[] num) {
//       System.out.println(Arrays.toString(num));
//    }
//
//    public static  void Print(int[] A) {
//        for (int i = 0; i < A.length; i++)
//            for (int j = i + 1; j < A.length; j++)
//                if (A[i] == A[j])
//                    System.out.println(A[i]);
//    }
//
//    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 78, 78};
//        int n = arr.length;
//       print(arr);
//        Print(arr);
//
//
//
//    }
//
//
//}


//Singles among doubles in the sorted array
//
//public class java_search.BinarySearch {
//
//
//    public static int single(int[] arr) {
//        int n = arr.length;
//        //base conditions
//        if (n == 1) return arr[0];//one element
//        if (arr[0] != arr[1]) return arr[0]; //starting
//        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];//ending
//
//
//        int low = 1;//uper edge cases rediscussed
//        int high = n - 2;
//        while (low <= high) {
//
//
//            int mid = low + (high - low) / 2;
//            //single element is at the mid
//            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
//                return arr[mid];
//
//            int f = mid;
//            int s = mid;
//            if (arr[mid - 1] == arr[mid]) f = mid - 1;
//
//            else s = mid + 1;
//
//            int leftCount = f - low;
//           int rightCount = high - s;
//
//            if (leftCount % 2 == 0) low = s + 1;
//            else high = f - 1;
//
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//
//        int brr[] = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 45};
//
//        System.out.println(single(brr));
//
//    }
//}

/// arranging the coin in the stair format and give the no of the full stairs

//public class java_search.BinarySearch {
//
//    public static void main(String[] args) {
//
//
//        int n = 13;// now arrange the number of coins
//        long low = 0;
//        long high = n;
//        int ans = 0;
//        while (low <= high) {
//            long k = low + (high - low) / 2;
//            long m = k + (k + 1) / 2;
//            if (m == n) return (int) k;
//            else if (m > n) {
//                high = k - 1;
//                else{
//                    ans = k;
//                    low = k + 1;
//                }
//            }
//
//
//
//            return (int)ans;
//        }
//
//    }
//


//search in the sorted  2D array


public class BinarySearch {

    public static void main(String[] args) {

        int[][] matrix = {{12, 14, 15, 16, 18}, {19, 20, 24, 25, 26}, {28, 29, 30, 31,33}};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j= cols - 1;
        int target =  24;


        while(i <  rows && j > 0){// i  sbese left mein hain aur j sbse right top most

            if(matrix[i][j] == target){
                System.out.println("found at i,j "+i+" "+j);
                return;
            }
            else if(matrix[i][j] > target) i++;
            else j--;

        }

        if(rows == i||j == 0) System.out.println("not found");

//
//                while (left <= right) {
//
//                    int mid = (left + right) / 2;
//
//
//
//
//
//                    int row = mid / cols;
//                    int col = mid % cols;
//                    int guess = matrix[row][col];
//
//                    if (guess == target) {
//                        return true;
//                    } else if (guess < target) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//
//                return false;








    }
}






