import java.util.Scanner;

/**
 * Write a program that reads a string input from the user and removes all consecutive
 * duplicate characters while maintaining the original order of distinct characters. The
 * program should then output the modified string.
 * <p>
 * Input - 223334566777
 * Output - 234567
 **/


public class L_Integer_Compression {
    /// we have to compress the integeer given in teh string form and like the string compression

    public static void main(String[] args) {

        ///String number = "222233345550";
        Scanner sc = new Scanner(System.in);


        String number = sc.nextLine();
        String ans = "";


        if (number.isEmpty()) System.out.println(" ");
        ans += number.charAt(0);


        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i - 1) != number.charAt(i)) ans += number.charAt(i);
            else continue;
        }
        System.out.println(ans);


    }


}
