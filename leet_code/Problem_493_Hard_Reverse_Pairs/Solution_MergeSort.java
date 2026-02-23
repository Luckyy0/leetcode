package leet_code.Problem_493_Hard_Reverse_Pairs;

import java.util.Arrays;

public class Solution_MergeSort {

    /**
     * Counts reverse pairs.
     * Strategy: Modified Merge Sort.
     * Time: O(N log N), Space: O(N).
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return 0;

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        // Count reverse pairs across the split
        // Left part: [start, mid], Right part: [mid+1, end]
        // Both parts are now sorted.

        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            // Use long to prevent overflow for large numbers
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Standard merge
        merge(nums, start, mid, end);

        return count;
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= end)
            temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, start, temp.length);
    }

    public static void main(String[] args) {
        Solution_MergeSort solution = new Solution_MergeSort();
        int[] nums = { 1, 3, 2, 3, 1 };
        System.out.println("Result: " + solution.reversePairs(nums)); // 2
    }
}
