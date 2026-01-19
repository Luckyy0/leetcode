package leetcode.P076_MinimumWindowSubstring;

public class Solution {

    /**
     * Problem 76: Minimum Window Substring
     * Approach: Sliding Window
     * Time Complexity: O(m + n)
     * Space Complexity: O(1) (128 ASCII chars)
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length(); // Handling total characters needed

        while (right < s.length()) {
            char rChar = s.charAt(right);
            // If current char is in t (count > 0), decrement total needed count
            if (map[rChar] > 0) {
                count--;
            }
            // Decrement map count (can go negative for extra chars)
            map[rChar]--;
            right++;

            // While valid window
            while (count == 0) {
                // Update min window
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                // Shrink from left
                char lChar = s.charAt(left);
                map[lChar]++;

                // If map[lChar] > 0, it means we are removing a needed character
                // (Only need logic applies if map value was originally positive and we brought
                // it down)
                if (map[lChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "ADOBECODEBANC", "ABC", "BANC");
        runTest(solution, "a", "a", "a");
        runTest(solution, "a", "aa", "");
        runTest(solution, "ab", "b", "b");
    }

    private static void runTest(Solution s, String str, String target, String expected) {
        System.out.println("Input: s=\"" + str + "\", t=\"" + target + "\"");
        String result = s.minWindow(str, target);
        System.out.println("Output: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
