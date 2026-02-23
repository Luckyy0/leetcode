package leet_code.Problem_775_Medium_Global_and_Local_Inversions;

public class Solution {

    /**
     * Checks if global inversions equal local inversions.
     * Strategy: Check if any element is displaced by more than 1 position.
     * Time: O(N), Space: O(1).
     */
    public boolean isIdealPermutation(int[] nums) {
        // A local inversion is also a global inversion.
        // For them to be equal, we cannot have any global inversion that is NOT local.
        // This means we cannot find i < j such that nums[i] > nums[j] with j > i + 1.
        // In a permutation of 0..N-1, this implies every number x must be at index x,
        // x-1, or x+1.

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 1, 0, 2 };
        System.out.println("Result 1: " + sol.isIdealPermutation(n1)); // true

        int[] n2 = { 1, 2, 0 };
        System.out.println("Result 2: " + sol.isIdealPermutation(n2)); // false
    }
}
