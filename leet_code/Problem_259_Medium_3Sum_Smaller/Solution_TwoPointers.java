package leet_code.Problem_259_Medium_3Sum_Smaller;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Finds the number of triplets with sum less than target.
     * Uses Sorting and Two Pointers.
     * Time: O(N^2), Space: O(1).
     * 
     * Tìm số lượng bộ ba có tổng nhỏ hơn target.
     * Sử dụng Sắp xếp và Hai con trỏ.
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    // If sum < target, then nums[i] + nums[left] + nums[R] < target
                    // for all R in (left, right].
                    // Because nums[R] < nums[right] (since sorted).
                    // So we have (right - left) valid triplets for this 'i' and 'left'.
                    // Nếu sum < target, thì nums[i] + nums[left] + nums[R] < target
                    // với mọi R trong (left, right].
                    // Vì nums[R] < nums[right] (do đã sắp xếp).
                    // Vậy ta có (right - left) bộ ba hợp lệ cho 'i' và 'left' này.
                    count += (right - left);
                    left++;
                } else {
                    // Sum too large, decrease right to reduce sum
                    // Tổng quá lớn, giảm right để giảm tổng
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [-2,0,1,3], target 2 -> 2
        int[] nums1 = { -2, 0, 1, 3 };
        System.out.println("Counts 1: " + solution.threeSumSmaller(nums1, 2));

        // Test Case 2: [], 0 -> 0
        int[] nums2 = {};
        System.out.println("Counts 2: " + solution.threeSumSmaller(nums2, 0));
    }
}
