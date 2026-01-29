package leetcode.P498_DiagonalTraverse;

public class Solution {

    /**
     * Problem 498: Diagonal Traverse
     * Approach: Simulation by switching directions based on row+col sum
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N) for the result array
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int k = 0;

        for (int s = 0; s < m + n - 1; s++) {
            if (s % 2 == 0) {
                // Upwards: row decreases, col increases
                int r = Math.min(s, m - 1);
                int c = s - r;
                while (r >= 0 && c < n) {
                    res[k++] = mat[r--][c++];
                }
            } else {
                // Downwards: row increases, col decreases
                int c = Math.min(s, n - 1);
                int r = s - c;
                while (c >= 0 && r < m) {
                    res[k++] = mat[r++][c--];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,4,7,5,3,6,8,9]
        int[][] mat1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] res1 = sol.findDiagonalOrder(mat1);
        System.out.println("Result: " + java.util.Arrays.toString(res1));
    }
}
