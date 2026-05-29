import java.util.*;
//
//import java.util.ArrayList;

public class PowerSet {

    //power set == it is the set of the subsets
//    public static void main(String[] args) {
//
//        String s = "abc";
//        subsets(" ", s, 0);
//
//    }
//
//    private static void subsets(String ans, String s, int idx) {
//
//        //pick skip  style coding
//        if (idx == s.length()) {
//
//            System.out.print(ans + " ");
//            return;
//        }
//
//        char ch  =  s.charAt(idx);
//        subsets(ans + ch,s,idx+1);//pick-- in this we add the new letter ansd increse the idx
//
//        subsets(ans, s,idx+1);// skip mei bss we increase the (idx).___


    public static void main(String[] args) {


        String s = "abc";
        List<String> list = new ArrayList<>();
        newSubset("", s, 0, list);
        Collections.sort(list);
        System.out.println(list);//



    }

    private static void newSubset(String ans, String s, int idx, List<String> list) {

        if (idx == s.length()) {


             if(ans.length() != 0)
                 list.add(ans);

            return;

        }

        char ch = s.charAt(idx);
        newSubset(ans + ch, s, idx + 1 ,list);//pick
        newSubset(ans, s, idx+1, list);//skipping the character array


    }


}

