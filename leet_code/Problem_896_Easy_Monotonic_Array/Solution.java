package leet_code.Problem_896_Easy_Monotonic_Array;

/**
 * Problem 896: Monotonic Array
 * https://leetcode.com/problems/monotonic-array/
 */
public class Solution {

    /**
     * Checks if the array is monotonic.
     * Strategy: Keep track of increasing and decreasing possibilities.
     * 
     * @param nums Array of integers.
     * @return True if monotonic.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một mảng là đơn điệu nếu nó hoàn toàn không giảm hoặc hoàn toàn
     *         không tăng.
     *         2. Sử dụng 2 cờ boolean: 'increasing' và 'decreasing', ban đầu đều là
     *         true.
     *         3. Duyệt qua mảng:
     *         - Nếu gặp phần tử nums[i] > nums[i+1], mảng không thể là "tăng đơn
     *         điệu",
     *         gán increasing = false.
     *         - Nếu gặp phần tử nums[i] < nums[i+1], mảng không thể là "giảm đơn
     *         điệu",
     *         gán decreasing = false.
     *         4. Cuối cùng, trả về (increasing || decreasing).
     */
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.isMonotonic(new int[] { 1, 2, 2, 3 })); // true
        System.out.println("Result: " + sol.isMonotonic(new int[] { 6, 5, 4, 4 })); // true
        System.out.println("Result: " + sol.isMonotonic(new int[] { 1, 3, 2 })); // false
    }
}
