import java.util.Arrays;

/**
 * TCS{2024}. Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs =["dog","racecar","car"]
 * Output: ""
 * <p>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Here are the approaches->
 * Horizontal scanning — compare strings one by one
 * Vertical scanning — compare characters column by column
 * Sorting — sort the strings and compare only the first and last
 * Divide and conquer — recursively find prefixes
 * Binary search — binary-search the length of the prefix
 **/

public class B_findthe_prefix {


    /**
     * ### 1\. Horizontal Scanning
     * <p>
     * - Take the **first string** as `prefix`.
     * - Compare `prefix` with the **next string**.
     * - Find their **common prefix**.
     * - Update `prefix` with this common part.
     * - Repeat for all strings.
     * - If `prefix` becomes empty, return `""`.
     * - Finally, `prefix` is the answer.
     * <p>
     * ### 2\. Vertical Scanning
     * <p>
     * - Start from **index `0`**.
     * - Take the character from the **first string**.
     * - Compare it with the same index in all other strings.
     * - If all characters match, move to the **next index**.
     * - If a mismatch or end of a string occurs, stop.
     * - Return all characters **before the mismatch**.
     * <p>
     * ### 3\. Sorting
     * <p>
     * - **Sort** all the strings alphabetically.
     * - Take the **first** and **last** strings.
     * - Compare their characters from left to right.
     * - Stop at the **first mismatch**.
     * - The matching characters form the common prefix.
     * - Return that prefix.
     * <p>
     * ### 4\. Divide & Conquer
     * <p>
     * - **Divide** the array into two halves.
     * - Find the common prefix of the **left half**.
     * - Find the common prefix of the **right half**.
     * - Compare those two prefixes.
     * - Their common part becomes the answer for that section.
     * - Continue until the whole array is covered.
     * <p>
     * ### 5\. Binary Search
     * <p>
     * - Find the **length of the shortest string**.
     * - Consider possible prefix lengths from `0` to that length.
     * - Check whether a chosen prefix length is common to **all strings**.
     * - If yes, search for a **longer** prefix.
     * - If no, search for a **shorter** prefix.
     * - The largest valid length gives the **Longest Common Prefix**.
     **/


    // 1. Horizontal Scanning
    static String horizontal(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }


    // 2. Vertical Scanning
    static String vertical(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (i >= strs[j].length() ||
                        strs[j].charAt(i) != ch) {

                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }


    // 3. Sorting
    static String sorting(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        while (i < first.length() &&
                i < last.length() &&
                first.charAt(i) == last.charAt(i)) {

            i++;
        }

        return first.substring(0, i);
    }


    // 4. Divide and Conquer
    static String divideAndConquer(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        return divide(strs, 0, strs.length - 1);
    }

    static String divide(String[] strs, int left, int right) {

        if (left == right)
            return strs[left];

        int mid = left + (right - left) / 2;

        String leftPrefix = divide(strs, left, mid);
        String rightPrefix = divide(strs, mid + 1, right);

        return commonPrefix(leftPrefix, rightPrefix);
    }

    static String commonPrefix(String a, String b) {

        int i = 0;

        while (i < a.length() &&
                i < b.length() &&
                a.charAt(i) == b.charAt(i)) {

            i++;
        }

        return a.substring(0, i);
    }


    // 5. Binary Search
    static String binarySearch(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        int minLength = Integer.MAX_VALUE;

        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0;
        int high = minLength;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, high );
    }

    static boolean isCommonPrefix(String[] strs, int length) {

        String prefix = strs[0].substring(0, length);

        for (int i = 1; i < strs.length; i++) {

            if (!strs[i].startsWith(prefix))
                return false;
        }

        return true;
    }


    // Main method
    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println("Horizontal: " + horizontal(strs));
        System.out.println("Vertical: " + vertical(strs));
        System.out.println("Sorting: " + sorting(strs));
        System.out.println("Divide & Conquer: " + divideAndConquer(strs));
        System.out.println("Binary Search: " + binarySearch(strs));
    }
}
