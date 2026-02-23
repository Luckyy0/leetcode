package leet_code.Problem_498_Medium_Diagonal_Traverse;

public class Solution_Simulation {

    /**
     * Traverses matrix in diagonal order.
     * Strategy: Simulate movement. Flip direction when hitting boundaries.
     * Time: O(M * N), Space: O(1).
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int r = 0, c = 0;
        boolean up = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[r][c];

            if (up) {
                // Moving Up-Right: r--, c++
                if (c == n - 1) {
                    // Hit right boundary -> Move Down (r + 1)
                    r++;
                    up = false;
                } else if (r == 0) {
                    // Hit top boundary -> Move Right (c + 1)
                    c++;
                    up = false;
                } else {
                    r--;
                    c++;
                }
            } else {
                // Moving Down-Left: r++, c--
                if (r == m - 1) {
                    // Hit bottom boundary -> Move Right (c + 1)
                    c++;
                    up = true;
                } else if (c == 0) {
                    // Hit left boundary -> Move Down (r + 1)
                    r++;
                    up = true;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] res = solution.findDiagonalOrder(mat);

        System.out.print("Result: ");
        for (int num : res)
            System.out.print(num + " ");
        // Expected: 1 2 4 7 5 3 6 8 9
    }
}
