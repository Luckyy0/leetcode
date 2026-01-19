package leetcode.P118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 118: Pascal's Triangle
     * Approach: Iterative Row Construction
     * 
     * Theoretical Basis:
     * - Pascal's triangle: each number = sum of two numbers directly above
     * - Row n has n elements
     * - First and last elements are always 1
     * - triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]
     * - Mathematical connection: C(n,k) = n! / (k! × (n-k)!)
     * 
     * Time Complexity: O(numRows²)
     * Space Complexity: O(1) extra (output not counted)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // First and last elements are 1
                    row.add(1);
                } else {
                    // Interior element = sum of two elements above
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: numRows = 5
        runTest(solution, 5);

        // Test 2: numRows = 1
        runTest(solution, 1);

        // Test 3: numRows = 10
        runTest(solution, 10);
    }

    private static void runTest(Solution s, int numRows) {
        List<List<Integer>> result = s.generate(numRows);
        System.out.println("numRows = " + numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
        System.out.println("-----------------");
    }
}
