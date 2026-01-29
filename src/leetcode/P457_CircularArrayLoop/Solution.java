package leetcode.P457_CircularArrayLoop;

public class Solution {

    /**
     * Problem 457: Circular Array Loop
     * Approach: Fast and Slow Pointers (Cycle Detection)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = getNext(nums, i);

            // Check sign consistency: nums[i] and its neighbors must have same sign
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[getNext(nums, fast)] > 0) {
                if (slow == fast) {
                    // Check for self-loop (cycle length 1)
                    if (slow == getNext(nums, slow))
                        break;
                    return true;
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }

            // Mark path as visited to avoid re-calculating
            int curr = i;
            int sign = nums[i];
            while (nums[curr] * sign > 0) {
                int next = getNext(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, int curr) {
        int n = nums.length;
        int next = (curr + nums[curr]) % n;
        if (next < 0)
            next += n;
        return next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [2,-1,1,2,2] -> true
        int[] nums1 = { 2, -1, 1, 2, 2 };
        runTest(sol, nums1, true);

        // [-1,2] -> false
        int[] nums2 = { -1, 2 };
        runTest(sol, nums2, false);

        // [-2,1,-1,-2,-2] -> false
        int[] nums3 = { -2, 1, -1, -2, -2 };
        runTest(sol, nums3, false);
    }

    private static void runTest(Solution sol, int[] nums, boolean expected) {
        boolean result = sol.circularArrayLoop(nums.clone());
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
