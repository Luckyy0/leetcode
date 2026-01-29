package leetcode.P495_TeemoAttacking;

public class Solution {

    /**
     * Problem 495: Teemo Attacking
     * Approach: Single pass interval summation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;

        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return total + duration;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,4], 2 -> 4
        System.out.println("Result 1: " + sol.findPoisonedDuration(new int[] { 1, 4 }, 2) + " (Expected: 4)");

        // [1,2], 2 -> 3
        System.out.println("Result 2: " + sol.findPoisonedDuration(new int[] { 1, 2 }, 2) + " (Expected: 3)");
    }
}
