package leet_code.Problem_413_Medium_Arithmetic_Slices;

public class Solution_DP {

    /**
     * Counts number of arithmetic subarrays.
     * Uses DP with space optimization.
     * Time: O(N), Space: O(1).
     * 
     * Đếm số lượng mảng con cấp số cộng.
     * Sử dụng quy hoạch động với tối ưu không gian.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int total = 0;
        int currentCount = 0;

        for (int i = 2; i < nums.length; i++) {
            // Check if current three elements form AP
            // Kiểm tra xem ba phần tử hiện tại có tạo thành cấp số cộng không
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentCount++;
                total += currentCount;
            } else {
                currentCount = 0;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,3,4] -> 3
        System.out.println("Result [1,2,3,4]: " + solution.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));

        // Test Case 2: [1,2,3,4,5] -> 6
        System.out.println("Result [1,2,3,4,5]: " + solution.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4, 5 }));
    }
}
