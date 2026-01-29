package leetcode.P324_WiggleSortII;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 324: Wiggle Sort II
     * Approach: Sort and Interleave (O(N log N))
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int n = nums.length;
        int mid = (n + 1) / 2;
        int smallPtr = mid - 1;
        int largePtr = n - 1;

        // Fill: Small at even (0, 2...), Large at odd (1, 3...)
        // Use reverse order to separate medians
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[smallPtr--];
            } else {
                nums[i] = copy[largePtr--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,5,1,1,6,4] -> [1,6,1,5,1,4] (Example output)
        int[] nums1 = { 1, 5, 1, 1, 6, 4 };
        runTest(solution, nums1);

        // [1,3,2,2,3,1] -> [2,3,1,3,1,2]
        int[] nums2 = { 1, 3, 2, 2, 3, 1 };
        runTest(solution, nums2);
    }

    private static void runTest(Solution s, int[] nums) {
        int[] input = Arrays.copyOf(nums, nums.length);
        s.wiggleSort(nums);
        System.out.println("Input: " + Arrays.toString(input) + " -> Result: " + Arrays.toString(nums));

        boolean valid = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                // nums[i] < nums[i+1]
                if (nums[i] >= nums[i + 1])
                    valid = false;
            } else {
                // nums[i] > nums[i+1]
                if (nums[i] <= nums[i + 1])
                    valid = false;
            }
        }

        if (valid) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
