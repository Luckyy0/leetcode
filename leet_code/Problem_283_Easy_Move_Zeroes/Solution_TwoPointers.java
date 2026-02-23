package leet_code.Problem_283_Easy_Move_Zeroes;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Moves zeroes to the end.
     * Uses Two Pointers (Swapping optimization).
     * Time: O(N), Space: O(1).
     * 
     * Di chuyển số không về cuối.
     * Sử dụng Hai con trỏ (Tối ưu hóa hoán đổi).
     */
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current element with the element at lastNonZeroFoundAt
                // Hoán đổi phần tử hiện tại với phần tử tại lastNonZeroFoundAt
                if (i != lastNonZeroFoundAt) {
                    // Optimization: Only swap if indices are different
                    // Tối ưu hóa: Chỉ hoán đổi nếu chỉ số khác nhau
                    int temp = nums[lastNonZeroFoundAt];
                    nums[lastNonZeroFoundAt] = nums[i];
                    nums[i] = temp;
                }
                lastNonZeroFoundAt++;
            }
        }
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [0,1,0,3,12] -> [1, 3, 12, 0, 0]
        int[] n1 = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(n1);
        System.out.println("Moved 1: " + Arrays.toString(n1));

        // Test Case 2: [0] -> [0]
        int[] n2 = { 0 };
        solution.moveZeroes(n2);
        System.out.println("Moved 2: " + Arrays.toString(n2));
    }
}
