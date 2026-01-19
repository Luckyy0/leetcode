package leetcode.P287_FindTheDuplicateNumber;

public class Solution {

    /**
     * Problem 287: Find the Duplicate Number
     * Approach: Floyd's Tortoise and Hare (Cycle Detection)
     * 
     * Theoretical Basis:
     * - Treat array as linked list i -> nums[i].
     * - Duplicate number is the entry point of the cycle.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,3,4,2,2] -> 2
        runTest(solution, new int[] { 1, 3, 4, 2, 2 }, 2);

        // [3,1,3,4,2] -> 3
        runTest(solution, new int[] { 3, 1, 3, 4, 2 }, 3);

        // [1,1] -> 1
        runTest(solution, new int[] { 1, 1 }, 1);

        // [1,1,2] -> 1
        runTest(solution, new int[] { 1, 1, 2 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.findDuplicate(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
