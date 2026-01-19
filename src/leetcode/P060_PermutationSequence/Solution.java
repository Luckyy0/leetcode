package leetcode.P060_PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 60: Permutation Sequence
     * Approach: Factorial Number System
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;

        // Initialize numbers [1, 2, ..., n] and factorial (n-1)!
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) {
                factorial *= i;
            }
        }

        k--; // Convert to 0-based index

        for (int i = n; i > 0; i--) {
            // Determine index of current digit
            int index = k / factorial;
            sb.append(numbers.get(index));
            numbers.remove(index);

            k %= factorial;

            // Update factorial for next iteration
            if (i > 1) {
                factorial /= (i - 1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, 3, "213");
        runTest(solution, 4, 9, "2314");
        runTest(solution, 3, 1, "123");
    }

    private static void runTest(Solution s, int n, int k, String expected) {
        System.out.println("Input: n=" + n + ", k=" + k);
        String result = s.getPermutation(n, k);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
