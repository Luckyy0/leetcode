package leet_code.Problem_69_Easy_Sqrt_x;

public class Solution_BinarySearch {

    /**
     * Calculates the square root of x rounded down.
     * Uses binary search with long to avoid overflow.
     * Tính căn bậc hai của x làm tròn xuống.
     * Sử dụng tìm kiếm nhị phân với kiểu long để tránh tràn số.
     */
    public int mySqrt(int x) {
        if (x < 2)
            return x;

        long left = 2;
        long right = x / 2;

        while (left <= right) {
            long pivot = left + (right - left) / 2;
            long num = pivot * pivot;

            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return (int) pivot;
            }
        }

        return (int) right;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        System.out.println("Test Case 1 (x=4): " + solution.mySqrt(4));
        // Expected: 2

        // Test Case 2
        System.out.println("Test Case 2 (x=8): " + solution.mySqrt(8));
        // Expected: 2

        // Test Case 3 (Max value)
        System.out.println("Test Case 3 (x=2147483647): " + solution.mySqrt(2147483647));
        // Expected: 46340
    }
}
