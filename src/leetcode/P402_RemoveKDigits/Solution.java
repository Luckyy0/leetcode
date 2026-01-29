package leetcode.P402_RemoveKDigits;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Problem 402: Remove K Digits
     * Approach: Monotonic Stack (Greedy)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        // If k is still greater than 0, remove digits from the end
        while (k > 0) {
            stack.removeLast();
            k--;
        }

        // Construct the string and remove leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "1432219", k = 3 -> "1219"
        runTest(solution, "1432219", 3, "1219");

        // "10200", k = 1 -> "200"
        runTest(solution, "10200", 1, "200");

        // "10", k = 2 -> "0"
        runTest(solution, "10", 2, "0");

        // "9", k = 1 -> "0"
        runTest(solution, "9", 1, "0");
    }

    private static void runTest(Solution sol, String num, int k, String expected) {
        String result = sol.removeKdigits(num, k);
        System.out.println("num: " + num + ", k: " + k + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
