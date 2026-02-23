package leet_code.Problem_52_Hard_N_Queens_II;

public class Solution_Counter {

    private int count = 0;

    /**
     * Returns the number of distinct solutions.
     * Uses Backtracking.
     * Trả về số lượng các giải pháp riêng biệt.
     * Sử dụng Quay lui.
     */
    public int totalNQueens(int n) {
        count = 0;
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n]; // row - col + (n-1)
        boolean[] d2 = new boolean[2 * n]; // row + col

        backtrack(0, n, cols, d1, d2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int id1 = row - col + (n - 1);
            int id2 = row + col;

            if (!cols[col] && !d1[id1] && !d2[id2]) {
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;

                backtrack(row + 1, n, cols, d1, d2);

                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution_Counter solution = new Solution_Counter();

        // Test Case 1
        System.out.println("Test Case 1 (n=4): " + solution.totalNQueens(4));
        // Expected: 2

        // Test Case 2
        System.out.println("Test Case 2 (n=1): " + solution.totalNQueens(1));
        // Expected: 1
    }
}
