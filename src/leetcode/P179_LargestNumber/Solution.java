package leetcode.P179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /**
     * Problem 179: Largest Number
     * Approach: Custom Comparator Sorting
     * 
     * Theoretical Basis:
     * - Combine A and B in two ways: AB and BA.
     * - If AB > BA, then A is "greater" than B in context of forming largest
     * number.
     * 
     * Time Complexity: O(N log N * L)
     * Space Complexity: O(N * L)
     */
    public String largestNumber(int[] nums) {
        // Convert to String array
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Sort with custom comparator
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                // Reverse order for descending
                return s2.compareTo(s1);
            }
        });

        // Handle edge case where all numbers are zero
        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [10, 2] -> "210"
        runTest(solution, new int[] { 10, 2 }, "210");

        // [3, 30, 34, 5, 9] -> "9534330"
        runTest(solution, new int[] { 3, 30, 34, 5, 9 }, "9534330");

        // [0, 0] -> "0"
        runTest(solution, new int[] { 0, 0 }, "0");
    }

    private static void runTest(Solution s, int[] nums, String expected) {
        String result = s.largestNumber(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
