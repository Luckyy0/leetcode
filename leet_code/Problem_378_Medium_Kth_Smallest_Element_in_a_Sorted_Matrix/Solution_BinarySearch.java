package leet_code.Problem_378_Medium_Kth_Smallest_Element_in_a_Sorted_Matrix;

public class Solution_BinarySearch {

    /**
     * Finds the kth smallest element in a sorted matrix.
     * Uses Binary Search on Value Range.
     * Time: O(N * log(Range)), Space: O(1).
     * 
     * Tìm phần tử nhỏ thứ k trong ma trận đã sắp xếp.
     * Sử dụng Tìm kiếm Nhị phân trên Khoảng Giá trị.
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count elements <= mid in O(N) using the step approach
    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int r = n - 1; // Start at bottom row
        int c = 0; // Start at first column

        while (r >= 0 && c < n) {
            if (matrix[r][c] <= target) {
                // All elements in current column above r are also <= target
                count += (r + 1);
                c++;
            } else {
                r--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: k=8 -> 13
        int[][] m1 = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        System.out.println("Result 1: " + solution.kthSmallest(m1, 8));

        // Test Case 2: k=1 -> -5
        int[][] m2 = { { -5 } };
        System.out.println("Result 2: " + solution.kthSmallest(m2, 1));
    }
}
