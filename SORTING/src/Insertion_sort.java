import java.util.Arrays;

public class Insertion_sort {


    public static void print(int[] a) {

        System.out.println(Arrays.toString(a));

    }

    public static void main(String[] args) {

        int[] arr = {23, 45, 23, -5, 555, 89, 90, 0};


//        print(arr);


        int n = arr.length;

        //logic of the insertion sort

//        1.. 1 se n-1 tak loop chalate hai... as (i)
//        2.. phir hum (j = i) usko compare krte hain j-1 se && j >0


        for (int i = 1; i < n; i++) {

            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {

                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            print(arr);

        }

//        print(arr);

    }
}
