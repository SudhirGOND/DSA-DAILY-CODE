import java.util.HashMap;

/**
 * Given a string, we need to find two things:
 * <p>
 * First non-repeating character
 * <p>
 * A character whose frequency is exactly 1.
 * <p>
 * We want the first one according to its position in the string.
 * <p>
 * Most repeated character
 * <p>
 * The character with the highest frequency.
 * <p>
 * If multiple characters have the same highest frequency, choose the one that appears first in the string.
 * <p>
 * There are also special cases:
 * <p>
 * Empty string → "Invalid Input"
 * <p>
 * No non-repeating character → print "None" followed by the most repeated character.
 **/

import java.util.*;

public class I_String_Operations {

    public static void main(String[] args) {


        String str = "abcde";

//        if(str.isEmpty()) System.out.print("Invalid Input");
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        char firstNonRepeating = '\0';
        char mostRepeated = '\0';

        int maxFrequency = 0;

        // Step 2: Find first non-repeating
        // and most repeated character
        for (char ch : str.toCharArray()) {

            int frequency = freq.get(ch);

            // First non-repeating character
            if (frequency == 1 && firstNonRepeating == '\0') {
                firstNonRepeating = ch;
            }

            // Most repeated character
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostRepeated = ch;
            }
        }
        // Step 3: Print result
        if (firstNonRepeating == '\0') {
            System.out.println("None " + mostRepeated);
        } else {
            System.out.println(firstNonRepeating + " " + mostRepeated);
        }

    }


}
