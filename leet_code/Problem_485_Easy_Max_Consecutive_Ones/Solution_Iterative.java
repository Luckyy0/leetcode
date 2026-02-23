package leet_code.Problem_485_Easy_Max_Consecutive_Ones;

public class Solution_Iterative {

    /**
     * Finds the maximum number of consecutive 1s.
     * Strategy: Iterate and count streak. Reset on 0.
     * Time: O(N), Space: O(1).
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
        }

        // Check finding after loop (in case array ends with 1s)
        return Math.max(maxCount, currentCount);
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println("Result: " + solution.findMaxConsecutiveOnes(nums)); // 3
    }
}
