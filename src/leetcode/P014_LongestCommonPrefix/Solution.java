package leetcode.P014_LongestCommonPrefix;

import java.util.Arrays;

public class Solution {

    /**
     * Approach 1: Horizontal Scanning
     * Time Complexity: O(S)
     * Space Complexity: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // While the current string (strs[i]) does not start with prefix
            // Trong khi chuỗi hiện tại (strs[i]) không bắt đầu bằng prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix from the end
                // Rút ngắn prefix từ cuối
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    /**
     * Approach 3: Sorting
     * Time Complexity: O(N*L*logN)
     */
    public String longestCommonPrefixSorted(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new String[] { "flower", "flow", "flight" }, "fl");
        runTest(solution, new String[] { "dog", "racecar", "car" }, "");
        runTest(solution, new String[] { "ab", "a" }, "a");
        runTest(solution, new String[] { "", "b" }, "");
        runTest(solution, new String[] { "single" }, "single");
    }

    private static void runTest(Solution s, String[] input, String expected) {
        System.out.print("Input: [");
        for (int i = 0; i < Math.min(input.length, 3); i++)
            System.out.print("\"" + input[i] + "\",");
        System.out.println("...]");

        String res = s.longestCommonPrefix(input);
        System.out.println("Output: \"" + res + "\" (Expected: \"" + expected + "\")");

        if (res.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
