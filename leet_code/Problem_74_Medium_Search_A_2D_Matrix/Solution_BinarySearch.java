package leet_code.Problem_74_Medium_Search_A_2D_Matrix;

public class Solution_BinarySearch {

    /**
     * Searches for a target value in a 2D sorted matrix.
     * Treats the matrix as a flattened array for O(log(m*n)) complexity.
     * Tìm kiếm giá trị mục tiêu trong ma trận 2 chiều đã sắp xếp.
     * Coi ma trận như một mảng trải phẳng để đạt độ phức tạp O(log(m*n)).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Mapping mid to row and col
            // Ánh xạ mid sang hàng và cột
            int row = mid / n;
            int col = mid % n;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[][] m1 = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        System.out.println("Test Case 1: " + solution.searchMatrix(m1, 3));
        // Expected: true

        // Test Case 2
        System.out.println("Test Case 2: " + solution.searchMatrix(m1, 13));
        // Expected: false
    }
}
