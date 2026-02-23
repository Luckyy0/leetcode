package leet_code.Problem_26_Easy_Remove_Duplicates_From_Sorted_Array;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Removes duplicates from sorted array in-place.
     * Uses Two Pointers approach.
     * Xóa các phần tử trùng lặp khỏi mảng đã sắp xếp tại chỗ.
     * Sử dụng phương pháp Hai Con Trỏ.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // i tracks the position of the last unique element
        // i theo dõi vị trí của phần tử duy nhất cuối cùng
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            // Nếu chúng ta tìm thấy một phần tử duy nhất mới
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] nums1 = { 1, 1, 2 };
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test Case 1: k=" + k1 + ", nums=" + Arrays.toString(Arrays.copyOf(nums1, k1)));
        // Expected: k=2, nums=[1, 2]

        // Test Case 2
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test Case 2: k=" + k2 + ", nums=" + Arrays.toString(Arrays.copyOf(nums2, k2)));
        // Expected: k=5, nums=[0, 1, 2, 3, 4]
    }
}
