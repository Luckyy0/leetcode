package leet_code.Problem_945_Medium_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

/**
 * Problem 945: Minimum Increment to Make Array Unique
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class Solution {

    /**
     * Calculates the minimum increments required to make all array elements unique.
     * Strategy: Sorting and Greedy Approach.
     * 
     * @param nums The input array.
     * @return Minimum number of moves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng `nums` theo thứ tự tăng dần.
     *         2. Duyệt qua mảng từ phần tử thứ 2 (index 1).
     *         3. Tại mỗi bước, so sánh phần tử hiện tại `nums[i]` với phần tử liền
     *         trước `nums[i-1]`.
     *         4. Nếu `nums[i] <= nums[i-1]`, nghĩa là `nums[i]` bị trùng hoặc nhỏ
     *         hơn giá trị cần thiết
     *         để duy trì tính duy nhất và tăng dần.
     *         5. Để tốn ít chi phí nhất, ta chỉ cần tăng `nums[i]` lên sao cho nó
     *         bằng `nums[i-1] + 1`.
     *         6. Số bước cần thực hiện là `(nums[i-1] + 1) - nums[i]`.
     *         Cộng số bước này vào tổng `moves` và cập nhật giá trị `nums[i]` mới.
     */
    public int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int moves = 0;

        for (int i = 1; i < nums.length; i++) {
            // Check if current value is not strictly greater than the previous one
            if (nums[i] <= nums[i - 1]) {
                // Calculate how much we need to increment
                int increment = nums[i - 1] + 1 - nums[i];

                // Add to total moves
                moves += increment;

                // Update the current value to be unique (one greater than prev)
                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 1, 2, 2 };
        System.out.println("Result: " + sol.minIncrementForUnique(n1)); // 1

        int[] n2 = { 3, 2, 1, 2, 1, 7 };
        System.out.println("Result: " + sol.minIncrementForUnique(n2)); // 6
    }
}
