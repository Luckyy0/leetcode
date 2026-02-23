package leet_code.Problem_189_Medium_Rotate_Array;

import java.util.Arrays;

public class Solution_Reverse {

    /**
     * Rotates the array to the right by k steps.
     * Uses the "Reverse Trick" for O(N) time and O(1) space.
     * 
     * Xoay mảng sang phải k bước.
     * Sử dụng "Thủ thuật đảo ngược" cho thời gian O(N) và không gian O(1).
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;

        // Ensure k is within array bounds
        // Đảm bảo k nằm trong giới hạn của mảng
        k %= nums.length;

        if (k == 0)
            return;

        // 1. Reverse the whole array
        // 1. Đảo ngược toàn bộ mảng
        reverse(nums, 0, nums.length - 1);

        // 2. Reverse the first k elements
        // 2. Đảo ngược k phần tử đầu tiên
        reverse(nums, 0, k - 1);

        // 3. Reverse the rest
        // 3. Đảo ngược phần còn lại
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution_Reverse solution = new Solution_Reverse();

        // Test Case 1: [1,2,3,4,5,6,7], k=3
        int[] n1 = { 1, 2, 3, 4, 5, 6, 7 };
        solution.rotate(n1, 3);
        System.out.println("Result 1: " + Arrays.toString(n1));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Test Case 2: [-1,-100,3,99], k=2
        int[] n2 = { -1, -100, 3, 99 };
        solution.rotate(n2, 2);
        System.out.println("Result 2: " + Arrays.toString(n2));
        // Expected: [3, 99, -1, -100]
    }
}
