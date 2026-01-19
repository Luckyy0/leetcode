package leetcode.P093_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 93: Restore IP Addresses
     * Approach: Backtracking
     * Time Complexity: Constant (at most 3^4 checks)
     * Space Complexity: O(1)
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> parts, List<String> result) {
        // Base case: used all characters and have 4 parts
        if (index == s.length() && parts.size() == 4) {
            result.add(String.join(".", parts));
            return;
        }

        // Pruning: too many parts or used all char but not 4 parts
        if (parts.size() >= 4 || index >= s.length()) {
            return;
        }

        // Try lengths 1, 2, 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length())
                break;

            String sub = s.substring(index, index + len);

            // Check leading zero and value range
            if ((sub.startsWith("0") && sub.length() > 1) || (len == 3 && Integer.parseInt(sub) > 255)) {
                continue;
            }

            parts.add(sub);
            backtrack(s, index + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "25525511135", 2);
        runTest(solution, "0000", 1);
        runTest(solution, "101023", 5);
    }

    private static void runTest(Solution s, String str, int expectedCount) {
        System.out.println("Input: \"" + str + "\"");
        List<String> result = s.restoreIpAddresses(str);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        System.out.println("Result: " + result);

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
