import java.util.*;

public class oneTON {


    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println();
        dhoom(1, 5);

}
//        System.out.println("Ramu kaka"+n);

        public static void dhoom(int i , int  t){


            if (i > t) return;

            System.out.println(i);

            dhoom(++i,5);


        }


    }

