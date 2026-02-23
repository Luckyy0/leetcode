package leet_code.Problem_761_Hard_Special_Binary_String;

import java.util.*;

public class Solution {

    /**
     * Rearranges the string to be lexicographically largest.
     * Strategy: Recursively decompose into special substrings, maximize their inner
     * parts, and sort them descending.
     * Time: O(N^2), Space: O(N^2).
     */
    public String makeLargestSpecial(String s) {
        int count = 0;
        int i = 0;
        List<String> res = new ArrayList<>();

        // Loop through the string to find top-level special substrings
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

            // When balance is 0, we found a valid special substring s[i...j]
            if (count == 0) {
                // The substring is "1" + inner + "0"
                // We recursively maximize the inner part: s.substring(i + 1, j)
                // And then wrap it back with "1" and "0"
                String inner = s.substring(i + 1, j);
                String optimizedPart = "1" + makeLargestSpecial(inner) + "0";

                res.add(optimizedPart);
                i = j + 1; // Move start pointer
            }
        }

        // Sort the substrings in descending order to form the largest string
        Collections.sort(res, Collections.reverseOrder());

        // Join all parts
        return String.join("", res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "11011000";
        System.out.println("Result 1: " + sol.makeLargestSpecial(s1));
        // Expected: "11100100" (from example analysis: inner "10" and "1100" -> swapped
        // to "1100" "10")

        String s2 = "10";
        System.out.println("Result 2: " + sol.makeLargestSpecial(s2));
        // Expected: "10"
    }
}
