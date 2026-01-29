package leetcode.P340_LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 340: Longest Substring with At Most K Distinct Characters
     * Approach: Sliding Window + HashMap
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(K)
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts.put(c, counts.getOrDefault(c, 0) + 1);

            while (counts.size() > k) {
                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.get(leftChar) - 1);
                if (counts.get(leftChar) == 0) {
                    counts.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "eceba", 2 -> 3
        runTest(solution, "eceba", 2, 3);

        // "aa", 1 -> 2
        runTest(solution, "aa", 1, 2);

        // "a", 0 -> 0
        runTest(solution, "a", 0, 0);
    }

    private static void runTest(Solution s, String str, int k, int expected) {
        int result = s.lengthOfLongestSubstringKDistinct(str, k);
        System.out.println("Input: " + str + ", k=" + k + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
