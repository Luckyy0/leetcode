package leetcode.P487_MaxConsecutiveOnesII;

public class Solution {

    /**
     * Problem 487: Max Consecutive Ones II
     * Approach: Sliding Window
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeros = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,0,1,1,0] -> 4
        System.out.println("Result: " + sol.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0 }) + " (Expected: 4)");

        // [1,0,1,1,0,1] -> 4
        System.out.println("Result: " + sol.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }) + " (Expected: 4)");
    }
}
