package leet_code.Problem_665_Medium_Non_decreasing_Array;

public class Solution {

    /**
     * Checks if an array can become non-decreasing with at most one modification.
     * Strategy: Greedy modification upon violation.
     * Time: O(N), Space: O(1).
     */
    public boolean checkPossibility(int[] nums) {
        int violations = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                violations++;
                if (violations > 1)
                    return false;

                // Violation at index i: nums[i] > nums[i+1]
                // We have two choices:
                // 1. Lower nums[i] to nums[i+1] (preferable)
                // 2. Raise nums[i+1] to nums[i] (fallback)

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    // Option 1: Lowering nums[i] is safe
                    // nums[i] = nums[i + 1]; // Implicitly done: we continue and i+1 becomes the
                    // new baseline
                } else {
                    // Option 1 fails (nums[i-1] > nums[i+1]), must use Option 2
                    // Raise nums[i+1] to nums[i] to satisfy nums[i] <= nums[i+1]
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result for [4,2,3]: " + sol.checkPossibility(new int[] { 4, 2, 3 })); // true
        System.out.println("Result for [4,2,1]: " + sol.checkPossibility(new int[] { 4, 2, 1 })); // false
    }
}
