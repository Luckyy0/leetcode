package leetcode.P308_RangeSumQuery2DMutable;

public class Solution {

    /**
     * Problem 308: Range Sum Query 2D - Mutable
     * Approach: 2D Binary Indexed Tree
     * 
     * Time Complexity: O(log M * log N) query/update
     * Space Complexity: O(MN)
     */
    public static class NumMatrix {

        private int[][] tree;
        private int[][] nums;
        private int m;
        private int n;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m + 1][n + 1];
            nums = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            if (m == 0 || n == 0)
                return;
            int delta = val - nums[row][col];
            nums[row][col] = val; // Store new value

            for (int i = row + 1; i <= m; i += i & (-i)) {
                for (int j = col + 1; j <= n; j += j & (-j)) {
                    tree[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0)
                return 0;
            return query(row2, col2) - query(row1 - 1, col2) - query(row2, col1 - 1) + query(row1 - 1, col1 - 1);
        }

        private int query(int row, int col) { // Sum from (0,0) to (row, col)
            int sum = 0;
            for (int i = row + 1; i > 0; i -= i & (-i)) {
                for (int j = col + 1; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };
        NumMatrix obj = new NumMatrix(matrix);

        // sumRegion(2, 1, 4, 3) -> 8
        runTest(obj, 2, 1, 4, 3, 8);

        // update(3, 2, 2)
        // Original matrix[3][2] was 0. Now it's 2. Delta = 2.
        // Region was sum=8. (3,2) is (row=3, col=2).
        // Region (2,1) to (4,3). Rows: 2, 3, 4. Cols: 1, 2, 3.
        // Cell (3,2) is INSIDE the region. So sum should increase by 2.
        // 8 + 2 = 10.
        obj.update(3, 2, 2);

        // sumRegion(2, 1, 4, 3) -> 10
        runTest(obj, 2, 1, 4, 3, 10);
    }

    private static void runTest(NumMatrix nm, int r1, int c1, int r2, int c2, int expected) {
        int result = nm.sumRegion(r1, c1, r2, c2);
        System.out.println("Region [" + r1 + "," + c1 + "] to [" + r2 + "," + c2 + "] -> " + result + " (Expected: "
                + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
