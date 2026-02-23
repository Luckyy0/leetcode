package leet_code.Problem_367_Easy_Valid_Perfect_Square;

public class Solution_BinarySearch {

    /**
     * Checks if num is a perfect square.
     * Uses Binary Search.
     * Time: O(log N), Space: O(1).
     * 
     * Kiểm tra xem num có phải là số chính phương không.
     * Sử dụng Tìm kiếm Nhị phân.
     */
    public boolean isPerfectSquare(int num) {
        if (num < 1)
            return false;
        long low = 1, high = num;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: 16 -> true
        System.out.println("Result 16: " + solution.isPerfectSquare(16));

        // Test Case 2: 14 -> false
        System.out.println("Result 14: " + solution.isPerfectSquare(14));
    }
}
