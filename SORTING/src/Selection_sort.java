import java.util.Arrays;

public class Selection_sort {

    public static void print(int[] a) {

        System.out.println(Arrays.toString(a));

    }
    public static void main(String[] args) {


        int[] arr = {23, 45, 23, -5, 555, 89, 90, 0};
        print(arr);
        int n = arr.length ;
        for (int i = 0; i < n ; i++) {

            int min = Integer.MAX_VALUE;
            int minidx = -1;
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minidx = j;
                }
                //  swapping the element
            }
            int temp = arr[i];
            arr[i] = arr[minidx];
            arr[minidx] = temp;
            print(arr);


        }

        print(arr);
    }
}


