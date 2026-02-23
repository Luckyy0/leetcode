package leet_code.Problem_308_Hard_Range_Sum_Query_2D_Mutable;

public class NumMatrix {

    private int[][] tree; // 2D BIT
    private int[][] matrix; // Store current values
    private int m;
    private int n;

    /**
     * Initializes with the input matrix.
     * Time: O(M*N log M log N) or O(M*N).
     * 
     * Khởi tạo với ma trận đầu vào.
     */
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = new int[m][n]; // Init with 0
        this.tree = new int[m + 1][n + 1];

        // Build tree by updating
        // Xây dựng cây bằng cách cập nhật
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    /**
     * Updates value at (row, col).
     * Time: O(log M log N).
     * 
     * Cập nhật giá trị tại (row, col).
     */
    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;

        // Update 2D BIT
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    /**
     * Returns sum of region.
     * Time: O(log M log N).
     * 
     * Trả về tổng của vùng.
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2, col2)
                - query(row1 - 1, col2)
                - query(row2, col1 - 1)
                + query(row1 - 1, col1 - 1);
    }

    // Returns sum from (0,0) to (row, col)
    private int query(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i)) {
            for (int j = col + 1; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
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

        System.out.println("Region 1: " + obj.sumRegion(2, 1, 4, 3)); // 8
        obj.update(3, 2, 2);
        System.out.println("Region 2: " + obj.sumRegion(2, 1, 4, 3)); // 10
    }
}
