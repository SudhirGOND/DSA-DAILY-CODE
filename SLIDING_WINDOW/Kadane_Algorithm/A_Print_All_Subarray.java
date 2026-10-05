public class A_Print_All_Subarray {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // Size of subarray
        for (int size = 1; size <= n; size++) {

            // Starting index
            for (int i = 0; i <= n - size; i++) {

                System.out.print("[ ");
                // Print elements of current subarray
                for (int j = i; j < i + size; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.print("]");

            }

            System.out.println();
        }
    }
}



