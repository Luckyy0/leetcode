package leet_code.Problem_280_Medium_Wiggle_Sort;

import java.util.Arrays;

public class Solution_Greedy {

    /**
     * Reorders array to wiggle sort.
     * Uses Greedy Swapping.
     * Time: O(N), Space: O(1).
     * 
     * Sắp xếp lại mảng thành sắp xếp lắc lư.
     * Sử dụng Hoán đổi Tham lam.
     */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                // Even index: nums[i] should be <= nums[i+1]
                // Chỉ số chẵn: nums[i] nên <= nums[i+1]
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                // Odd index: nums[i] should be >= nums[i+1]
                // Chỉ số lẻ: nums[i] nên >= nums[i+1]
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [3,5,2,1,6,4] -> [3, 5, 1, 6, 2, 4] (One possibility)
        int[] n1 = { 3, 5, 2, 1, 6, 4 };
        solution.wiggleSort(n1);
        System.out.println("Wiggle 1: " + Arrays.toString(n1));
    }
}
