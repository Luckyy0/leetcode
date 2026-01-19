package leetcode.P119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 119: Pascal's Triangle II
     * Approach: In-Place Update (Right to Left)
     * 
     * Theoretical Basis:
     * - Only need to return single row, not entire triangle
     * - Can update row in-place by processing right to left
     * - Right to left prevents overwriting values still needed for computation
     * - row[j] = row[j-1] + row[j] (but process j from high to low)
     * 
     * Time Complexity: O(rowIndex²)
     * Space Complexity: O(rowIndex) - only one row stored
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            // Add new element at end
            row.add(1);

            // Update interior elements from right to left
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }

    /**
     * Alternative: Using mathematical formula
     * C(n, k) = C(n, k-1) × (n - k + 1) / k
     */
    public List<Integer> getRowMath(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;

        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) val);
            // Calculate next value using formula: C(n,k+1) = C(n,k) × (n-k) / (k+1)
            val = val * (rowIndex - k) / (k + 1);
        }

        return row;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: rowIndex = 3 -> [1,3,3,1]
        runTest(solution, 3, new int[] { 1, 3, 3, 1 });

        // Test 2: rowIndex = 0 -> [1]
        runTest(solution, 0, new int[] { 1 });

        // Test 3: rowIndex = 1 -> [1,1]
        runTest(solution, 1, new int[] { 1, 1 });

        // Test 4: rowIndex = 5 -> [1,5,10,10,5,1]
        runTest(solution, 5, new int[] { 1, 5, 10, 10, 5, 1 });
    }

    private static void runTest(Solution s, int rowIndex, int[] expected) {
        List<Integer> result = s.getRow(rowIndex);
        List<Integer> resultMath = s.getRowMath(rowIndex);

        System.out.println("rowIndex = " + rowIndex);
        System.out.println("In-Place: " + result);
        System.out.println("Math:     " + resultMath);

        boolean pass = result.size() == expected.length && resultMath.size() == expected.length;
        for (int i = 0; i < expected.length && pass; i++) {
            if (result.get(i) != expected[i] || resultMath.get(i) != expected[i]) {
                pass = false;
            }
        }
        System.out.println(pass ? "PASS" : "FAIL");
        System.out.println("-----------------");
    }
}
