package leet_code.Problem_830_Easy_Positions_of_Large_Groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Finds the positions of all large groups (length >= 3).
     * Strategy: Sequential scan using two pointers to identify runs of same
     * characters.
     * Time: O(N), Space: O(1) extra.
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        // Loop through the string identifying each group
        while (i < n) {
            int j = i;
            // Move j to find the end of the current character group
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            // If the group length is 3 or more, add to result
            if (j - i >= 3) {
                result.add(Arrays.asList(i, j - 1));
            }

            // Advance original pointer i to the start of the next group
            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.largeGroupPositions("abbxxxxzzy"));
        // [[3, 6]]

        System.out.println("Result 2: " + sol.largeGroupPositions("abc"));
        // []

        System.out.println("Result 3: " + sol.largeGroupPositions("abcdddeeeeaabbbcd"));
        // [[3, 5], [6, 9], [12, 14]]
    }
}
