


import java.util.Arrays;


public class Bubble_sort {

    public static void print(int[] a) {

       System.out.println(Arrays.toString(a));

    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter the number : ");
//        String s = sc.nextLine();
//
//
//        System.out.println(s);
//    }


        int [] arr = {2, 4, 56, 6, 2232,9,0};
        print(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int x = 0;// check that the arr is already sorted ?

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//ascending order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    x++;
                    print(arr);
                }
            }
            if (x == 0) break;

        }

        print(arr);//printing the array























    }


















}



