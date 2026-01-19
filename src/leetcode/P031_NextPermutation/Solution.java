package leetcode.P031_NextPermutation;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 31: Next Permutation
     * Approach: Single Pass
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int i = nums.length - 2;
        // 1. Find the first decreasing element from the end
        // 1. Tìm phần tử giảm đầu tiên từ cuối
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. If such element found, find the element just larger than it from the end
        // 2. Nếu tìm thấy phần tử như vậy, tìm phần tử lớn hơn nó một chút từ cuối
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. Reverse the suffix starting from i + 1
        // 3. Đảo ngược hậu tố bắt đầu từ i + 1
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 });
        runTest(solution, new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 });
        runTest(solution, new int[] { 1, 1, 5 }, new int[] { 1, 5, 1 });
        runTest(solution, new int[] { 1, 3, 2 }, new int[] { 2, 1, 3 });
    }

    private static void runTest(Solution s, int[] input, int[] expected) {
        System.out.println("Input: " + Arrays.toString(input));

        // Work on clone? Requirement is in-place.
        // If we want to verify properly we should pass the array itself but print
        // carefully.
        int[] nums = input.clone();

        s.nextPermutation(nums);

        System.out.println("Output: " + Arrays.toString(nums) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(nums, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
