package leet_code.Problem_31_Medium_Next_Permutation;

import java.util.Arrays;

public class Solution_Permutation {

    /**
     * Modifies the array to the next lexicographical permutation.
     * Uses Two Pointers approach.
     * Sửa đổi mảng thành hoán vị tiếp theo về mặt từ điển.
     * Sử dụng phương pháp Hai Con Trỏ.
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;

        // Find the first decreasing element from the end
        // Tìm phần tử giảm dần đầu tiên từ cuối
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            // Find the element just larger than nums[i]
            // Tìm phần tử lớn hơn nums[i] một chút
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Reverse the suffix
        // Đảo ngược hậu tố
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Permutation solution = new Solution_Permutation();

        // Test Case 1
        int[] n1 = { 1, 2, 3 };
        solution.nextPermutation(n1);
        System.out.println("Test Case 1: " + Arrays.toString(n1));
        // Expected: [1, 3, 2]

        // Test Case 2
        int[] n2 = { 3, 2, 1 };
        solution.nextPermutation(n2);
        System.out.println("Test Case 2: " + Arrays.toString(n2));
        // Expected: [1, 2, 3]

        // Test Case 3
        int[] n3 = { 1, 1, 5 };
        solution.nextPermutation(n3);
        System.out.println("Test Case 3: " + Arrays.toString(n3));
        // Expected: [1, 5, 1]
    }
}
