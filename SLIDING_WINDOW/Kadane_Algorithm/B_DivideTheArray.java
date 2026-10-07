
public class B_DivideTheArray {
    public static void main(String[] args) {

        int[] arr = {0, 0, 3, 7, -9, 5};
        int n = arr.length;
        boolean flag = false;
        for (int i = 1; i < arr.length - 1; i++) {


            /// find the sum i tak
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++)
                sum1 += arr[j];
            // find the sum2 after that partition
            for (int j = i; j < arr.length; j++) sum2 += arr[j];

            if (sum1 == sum2) flag = (!flag);
        }
        System.out.println(flag); ///// Its time complexity will be 0(n^2 )
        optimized(arr);
    }


    /// Optimized code likhne ja rha hoon
    /// Suffix and prefix array ka use krr sakte ho
    /// Ya usse aacha approach ye hain ki -> total sum karr lo phir left se perfix nikal  minnus karo aur equal check karo

    public static void optimized(int[] arr) {

        int totalSum = 0;
        boolean flag = false;
        for (int i : arr) totalSum += i;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == totalSum - prefixSum) flag = true;
        }
        System.out.println("Optimized way : "+flag);
    }

}
