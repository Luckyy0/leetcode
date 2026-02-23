package leet_code.Problem_885_Medium_Spiral_Matrix_III;

/**
 * Problem 885: Spiral Matrix III
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class Solution {

    /**
     * Returns the coordinates of the grid in spiral order.
     * Strategy: Simulation.
     * 
     * @param rows   Number of rows.
     * @param cols   Number of columns.
     * @param rStart Starting row.
     * @param cStart Starting column.
     * @return 2D array of coordinates.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bắt đầu từ (rStart, cStart).
     *         2. Di chuyển theo hướng: Đông, Nam, Tây, Bắc.
     *         3. Độ dài bước đi tuân theo quy luật: 1, 1, 2, 2, 3, 3, 4, 4...
     *         (tức là cứ sau 2 lần đổi hướng, độ dài bước tăng lên 1).
     *         4. Mỗi lần di chuyển 1 ô, kiểm tra xem ô đó có nằm trong lưới không.
     *         Nếu có, thêm vào danh sách kết quả.
     *         5. Lặp lại cho đến khi thu thập đủ số lượng ô (rows * cols).
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        int count = 0;

        // Start position
        result[count++] = new int[] { rStart, cStart };
        if (totalCells == 1)
            return result;

        int r = rStart;
        int c = cStart;

        // Directions: East (0, 1), South (1, 0), West (0, -1), North (-1, 0)
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dirIdx = 0;
        int stepLength = 1;

        while (count < totalCells) {
            // Perform two legs for each step length
            for (int i = 0; i < 2; i++) {
                // Move stepLength times in the current direction
                for (int k = 0; k < stepLength; k++) {
                    r += dirs[dirIdx][0];
                    c += dirs[dirIdx][1];

                    // Check if the new position is valid
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[] { r, c };
                        if (count == totalCells)
                            return result;
                    }
                }

                // Change direction: 0->1->2->3->0...
                dirIdx = (dirIdx + 1) % 4;
            }
            // After two legs, increase step length
            stepLength++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] res1 = sol.spiralMatrixIII(1, 4, 0, 0);
        // [[0,0],[0,1],[0,2],[0,3]]
        System.out.println("Result 1 First: " + res1[0][0] + "," + res1[0][1]);

        int[][] res2 = sol.spiralMatrixIII(5, 6, 1, 4);
        // [[1,4],[1,5],[2,5]...]
        System.out.println("Result 2 First: " + res2[0][0] + "," + res2[0][1]);
    }
}
