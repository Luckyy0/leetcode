package leetcode.P388_LongestAbsoluteFilePath;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 388: Longest Absolute File Path
     * Approach: HashMap for Path Lengths
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(D)
     */
    public int lengthLongestPath(String input) {
        Map<Integer, Integer> pathLen = new HashMap<>();
        pathLen.put(0, 0); // Base case: depth 0 has length 0

        int maxLen = 0;

        for (String part : input.split("\n")) {
            // Count tabs to determine depth
            int depth = countTabs(part);
            String name = part.substring(depth); // Remove tabs

            if (name.contains(".")) {
                // It's a file
                int filePathLen = pathLen.get(depth) + name.length();
                maxLen = Math.max(maxLen, filePathLen);
            } else {
                // It's a directory
                // +1 for the '/' separator
                pathLen.put(depth + 1, pathLen.get(depth) + name.length() + 1);
            }
        }

        return maxLen;
    }

    private int countTabs(String s) {
        int count = 0;
        while (count < s.length() && s.charAt(count) == '\t') {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" -> 20
        runTest(solution, "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext", 20);

        // "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        // -> 32
        runTest(solution, "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext",
                32);

        // "a" -> 0 (no file)
        runTest(solution, "a", 0);
    }

    private static void runTest(Solution s, String input, int expected) {
        int result = s.lengthLongestPath(input);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
