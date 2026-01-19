package leetcode.P247_StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 247: Strobogrammatic Number II
     * Approach: Recursive Construction
     * 
     * Theoretical Basis:
     * - Expand from center (n=0 or n=1) outwards.
     * - Pairs: 11, 69, 88, 96, 00.
     * - Avoid 00 at the outermost layer.
     * 
     * Time Complexity: O(5^(N/2))
     * Space Complexity: O(N) recursion
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int k, int n) {
        if (k == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (k == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> subList = helper(k - 2, n);
        List<String> result = new ArrayList<>();

        for (String s : subList) {
            // Pair: 11
            result.add("1" + s + "1");

            // Pair: 69
            result.add("6" + s + "9");

            // Pair: 88
            result.add("8" + s + "8");

            // Pair: 96
            result.add("9" + s + "6");

            // Pair: 00 (Only if not outermost shell)
            if (k != n) {
                result.add("0" + s + "0");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // n=2 -> ["11","69","88","96"]
        runTest(solution, 2);

        // n=1 -> ["0","1","8"]
        runTest(solution, 1);

        // n=3 -> ["101", "111", "181", ...]
        runTest(solution, 3);
    }

    private static void runTest(Solution s, int n) {
        List<String> result = s.findStrobogrammatic(n);
        System.out.println("n=" + n + " -> Count: " + result.size());
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}
