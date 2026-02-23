package leet_code.Problem_799_Medium_Champagne_Tower;

public class Solution {

    /**
     * Calculates the fullness of a specific glass in the champagne tower.
     * Strategy: DP Simulation row by row.
     * Time: O(R^2) where R is query_row. Space: O(R^2).
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Use a grid to keep track of sâm panh entering each glass
        // We use 101 to handle overflow to the next row safely
        double[][] tower = new double[102][102];

        // Initial pour at the top
        tower[0][0] = (double) poured;

        // Iterate through rows to simulate flow
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                // If the glass overflows (> 1 cup)
                if (tower[r][c] > 1.0) {
                    double overflow = (tower[r][c] - 1.0) / 2.0;
                    // Add half of overflow to the two glasses immediately below
                    tower[r + 1][c] += overflow;
                    tower[r + 1][c + 1] += overflow;
                }
            }
        }

        // The result is the amount in the glass, capped at 1.0
        return Math.min(1.0, tower[query_row][query_glass]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.champagneTower(1, 1, 1)); // 0.0
        System.out.println("Result 2: " + sol.champagneTower(2, 1, 1)); // 0.5
        System.out.println("Result 3: " + sol.champagneTower(100000009, 33, 17)); // 1.0
    }
}
