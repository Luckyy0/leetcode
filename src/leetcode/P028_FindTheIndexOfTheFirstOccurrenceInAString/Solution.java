package leetcode.P028_FindTheIndexOfTheFirstOccurrenceInAString;

public class Solution {

    /**
     * Problem 28: Find the Index of the First Occurrence in a String
     * Approach: Simple Sliding Window
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "sadbutsad", "sad", 0);
        runTest(solution, "leetcode", "leeto", -1);
        runTest(solution, "hello", "ll", 2);
    }

    private static void runTest(Solution s, String haystack, String needle, int expected) {
        System.out.println("Haystack: \"" + haystack + "\", Needle: \"" + needle + "\"");
        int result = s.strStr(haystack, needle);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
