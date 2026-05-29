import java.util.Scanner;

public class BasicsBitwise {


    public static void main(String[] args) {

//        System.out.println(51 & 21);// bitwise    AND opration

//        int x = 5;
//        System.out.println(~x + " Ones compliment");
//        System.out.println(~x + 1 + " twos compliment");
//    try two sol  the question in the left shft
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        System.out.println((long) 1 << num); /////  multiplying the 1 in the  n times with 231


        ///// power of the two


        //// 1 .....  Count the Set bits of the( bacaz there are only one set bits into the power of two)
        /// n   ==  73
        /// n  ==  128
        /// 2 ...  divide the number upto the 1 -- then false  lll


    }




}
