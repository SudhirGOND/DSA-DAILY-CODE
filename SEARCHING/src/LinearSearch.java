import java.util.Arrays;

class LinearSearch {
    public static void main(String[] args) {
        int  arr[] = {1,34,35,45,233,23,2435,35,46,346,5634,34,343434576,45};
        System.out.println(Arrays.toString(arr));
        System.out.println("Size of the array is "+arr.length);

        int target  = 45;

        //its TC is the =  0(n) -- worst case
        //best case   =  0(1)..when element is at index 1st
        for (int i = 0; i <arr.length ; i++) {
            if(target == arr[i]){
                System.out.println("Found at index i = "+ i );
//                break;
            }
        }
    }
}