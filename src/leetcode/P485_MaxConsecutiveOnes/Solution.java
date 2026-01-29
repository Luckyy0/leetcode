package leetcode.P485_MaxConsecutiveOnes;

public class Solution {

    /**
     * Problem 485: Max Consecutive Ones
     * Approach: Single pass counter
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;

        for (int num : nums) {
            if (num == 1) {
                current++;
                if (current > max)
                    max = current;
            } else {
                current = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,1,0,1,1,1] -> 3
        System.out.println("Result: " + sol.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));

        // [1,0,1,1,0,1] -> 2
        System.out.println("Result: " + sol.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }
}
