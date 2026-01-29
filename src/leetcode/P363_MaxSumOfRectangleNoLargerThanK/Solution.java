package leetcode.P363_MaxSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

public class Solution {

    /**
     * Problem 363: Max Sum of Rectangle No Larger Than K
     * Approach: 2D Compression + TreeSet
     * 
     * Time Complexity: O(min(M,N)^2 * max(M,N) * log(max(M,N)))
     * Space Complexity: O(max(M,N))
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;

        // Optimize: Iterate over the smaller dimension for outer loops
        // Let's stick to columns for simplicity, or check boundaries
        boolean colIsSmall = n <= m;
        int outer = colIsSmall ? n : m;
        int inner = colIsSmall ? m : n;

        for (int i = 0; i < outer; i++) {
            int[] sums = new int[inner];
            for (int j = i; j < outer; j++) {
                // Update compressed sums
                for (int x = 0; x < inner; x++) {
                    sums[x] += colIsSmall ? matrix[x][j] : matrix[j][x];
                }

                // Find max subarray sum <= k in 'sums'
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currSum = 0;

                for (int s : sums) {
                    currSum += s;
                    Integer ceil = set.ceiling(currSum - k); // prev >= curr - k => curr - prev <= k
                    if (ceil != null) {
                        max = Math.max(max, currSum - ceil);
                    }
                    set.add(currSum);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,0,1],[0,-2,3]], k=2 -> 2
        int[][] m1 = { { 1, 0, 1 }, { 0, -2, 3 } };
        runTest(solution, m1, 2, 2);

        // [[2,2,-1]], k=3 -> 3
        int[][] m2 = { { 2, 2, -1 } };
        runTest(solution, m2, 3, 3);

        // [[2,2,-1]], k=0 -> -1
        runTest(solution, m2, 0, -1);
    }

    private static void runTest(Solution s, int[][] m, int k, int expected) {
        int result = s.maxSumSubmatrix(m, k);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
