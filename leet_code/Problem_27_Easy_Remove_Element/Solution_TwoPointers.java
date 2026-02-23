package leet_code.Problem_27_Easy_Remove_Element;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Removes specified element from array in-place.
     * Uses Two Pointers approach.
     * Xóa phần tử được chỉ định khỏi mảng tại chỗ.
     * Sử dụng phương pháp Hai Con Trỏ.
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current element is not the target value
            // Nếu phần tử hiện tại không phải là giá trị mục tiêu
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] nums1 = { 3, 2, 2, 3 };
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("Test Case 1: k=" + k1 + ", nums=" + Arrays.toString(Arrays.copyOf(nums1, k1)));
        // Expected: k=2, nums=[2, 2]

        // Test Case 2
        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("Test Case 2: k=" + k2 + ", nums=" + Arrays.toString(Arrays.copyOf(nums2, k2)));
        // Expected: k=5, nums contain [0, 1, 4, 0, 3] (order may vary)
    }
}
