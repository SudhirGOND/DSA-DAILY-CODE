import java.util.*;


/// Given an array nums of distinct integers, return all the possible permutations.
/// You can return the answer in any order.
/// Input: nums = [1,2,3]
/// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

//
//public class PERMUTATIONS {
//    public static void main(String[] args) {
//
//        String str = "abc";
//        printPer(str, "");
//
//
//    }
//
//    private static void printPer(String str, String s) {
//
//
//
//        if(str.equals("")) {
//            System.out.println(s);
//            return ;
//        }
//        for (int i = 0; i < str.length(); i++) {
//
//            char ch = str.charAt(i);// let   i = 1 === b
//            String left = str.substring(0, i); //  i  is excluded == a
//            String right = str.substring(i + 1); // i+1 to last itself == c
//            String rem  = left + right;
//            printPer(rem,s+ch); // khali string ke piche lga diye aur..
//
//        }
//
//
//    }
//}


///  returning the answer in the  list format

//
//public class PERMUTATIONS {
//    public static void main(String[] args) {
//
//        String str = "abc";
//
//        List<String> ans = new ArrayList<>();
//
//
//        printPer(str, ans, "");
/// /        Collections.sort(ans);
/// /        for (int i = 0; i < ans.size(); i++) {
/// /            System.out.print(" " + ans.get(i));
/// /        }
//
//        System.out.println(ans);
//
//    }
//
//    private static void printPer(String str, List<String> ans, String s) {
//
//
//        if (str.equals("")) {
//            ans.add(s);
//            return;
//        }
//        for (int i = 0; i < str.length(); i++) {
//
//            char ch = str.charAt(i);// let   i = 1 === b
//
//            String left = str.substring(0, i); //  i  is excluded == a
//            String right = str.substring(i + 1); // i+1 to last itself == c
//            String rem = left + right;
//
//            printPer(rem, ans, s + ch); // khali string ke piche lga diye aur..
//
//        }
//
//
//    }
//}
//
//


/// /going to solve the main question of the leetcode having the list into list

public class PERMUTATIONS {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> anderList = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];//same size as of the given array

        printPer(arr, ans, anderList, visited);
        System.out.println(ans);

    }

    private static void printPer(int[] arr, List<List<Integer>> ans, List<Integer> anderList, boolean[] visited) {


        if (anderList.size() == arr.length ) {
            List<Integer> list  =  new ArrayList<>();
            for(int  i = 0 ; i < anderList.size() ; i++){

                list.add(anderList.get(i));
            }
            ans.add(list);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                anderList.add(arr[i]); // let   i = 1 === b

                visited[i] = true; // now true after

                printPer(arr, ans, anderList, visited); // khali string ke piche lga diye aur..
                //backtracking and making false
                visited[i] = false;
//                anderList.remove(anderList.size() -1);// remove the last element
                anderList.removeLast();

            }
        }

    }

}




