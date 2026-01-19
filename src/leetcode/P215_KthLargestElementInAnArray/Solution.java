package leetcode.P215_KthLargestElementInAnArray;

import java.util.Random;

public class Solution {

    /**
     * Problem 215: Kth Largest Element in an Array
     * Approach: QuickSelect (Hoare's Partition scheme or Lomuto)
     * 
     * Theoretical Basis:
     * - Partition array around a pivot.
     * - Only recurse into the half that contains the k-th target index.
     * - Target index = nums.length - k (0-indexed sorted position).
     * 
     * Time Complexity: O(N) average
     * Space Complexity: O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int left = 0;
        int right = n - 1;
        Random rand = new Random();

        while (left <= right) {
            int pivotIndex = partition(nums, left, right, rand);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return nums[target];
    }

    private int partition(int[] nums, int left, int right, Random rand) {
        // Randomized pivot to avoid worst-case O(N^2)
        int pivotIdx = left + rand.nextInt(right - left + 1);
        int pivotValue = nums[pivotIdx];

        // Move pivot to end
        swap(nums, pivotIdx, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(nums, storeIndex, right);

        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,2,1,5,6,4], k = 2 -> 5
        runTest(solution, new int[] { 3, 2, 1, 5, 6, 4 }, 2, 5);

        // [3,2,3,1,2,4,5,5,6], k = 4 -> 4
        runTest(solution, new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4, 4);
    }

    private static void runTest(Solution s, int[] nums, int k, int expected) {
        // Clone array since QuickSelect modifies it
        int[] numsClone = nums.clone();
        int result = s.findKthLargest(numsClone, k);
        System.out.print("Array size: " + nums.length + ", k: " + k);
        System.out.println(" -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
