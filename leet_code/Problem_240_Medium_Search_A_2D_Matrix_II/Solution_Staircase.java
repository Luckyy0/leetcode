package leet_code.Problem_240_Medium_Search_A_2D_Matrix_II;

public class Solution_Staircase {

    /**
     * Searches for a target in a row-sorted and column-sorted matrix.
     * Uses the Staircase Search starting from top-right corner.
     * Time: O(M + N), Space: O(1).
     * 
     * Tìm kiếm target trong ma trận đã sắp xếp theo hàng và cột.
     * Sử dụng Tìm kiếm bậc thang bắt đầu từ góc trên bên phải.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        // Bắt đầu từ góc trên bên phải
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int currentVal = matrix[row][col];

            if (currentVal == target) {
                return true;
            } else if (currentVal > target) {
                // If current is larger than target, target cannot be in this column (since col
                // is sorted)
                // Move left
                // Nếu hiện tại lớn hơn target, target không thể ở cột này (vì cột đã sắp xếp)
                // Di chuyển sang trái
                col--;
            } else {
                // If current is smaller than target, target cannot be in this row (since row is
                // sorted)
                // Move down
                // Nếu hiện tại nhỏ hơn target, target không thể ở hàng này (vì hàng đã sắp xếp)
                // Di chuyển xuống dưới
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Staircase solution = new Solution_Staircase();

        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        // Test Case 1: Target 5 -> true
        System.out.println("Search 5: " + solution.searchMatrix(matrix, 5));

        // Test Case 2: Target 20 -> false
        System.out.println("Search 20: " + solution.searchMatrix(matrix, 20));
    }
}
