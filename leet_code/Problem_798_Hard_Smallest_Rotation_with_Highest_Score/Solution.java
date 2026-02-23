package leet_code.Problem_798_Hard_Smallest_Rotation_with_Highest_Score;

public class Solution {

    /**
     * Finds the rotation k that maximizes the count of nums[i] <= i.
     * Strategy: Difference Array (Interval updates).
     * Time: O(N), Space: O(N).
     */
    public int bestRotation(int[] nums) {
        int n = nums.length;
        // change[k] stores the score change from rotation k to k+1?
        // Let's use it to track when a point is UN-gained (lost).
        // For each nums[i], as k increases, the index decreases.
        // It loses a point when index becomes nums[i] - 1.
        // This happens at k = (i - nums[i] + 1 + n) % n.
        // Every rotation also moves the element at k-1 to the last index n-1.
        // This always gains a point (since nums[i] < n).

        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            // Point lost at rotation k = (i - nums[i] + 1 + n) % n
            int kLoss = (i - nums[i] + 1 + n) % n;
            change[kLoss]--;
        }

        // After each rotation k (moving from k-1 to k),
        // the element nums[k-1] moved from index 0 to index n-1.
        // It definitely scores now (since nums[i] < n).
        // But what about other points?
        // The difference array logic:
        // Score(k) = Score(k-1) + 1 + change[k]
        // "+ 1" because the element that moved to the end now scores.

        int maxScore = -1;
        int currentScore = 0;
        int bestK = 0;

        // Initial score for k=0
        for (int i = 0; i < n; i++) {
            if (nums[i] <= i)
                currentScore++;
        }

        maxScore = currentScore;

        for (int k = 1; k < n; k++) {
            // Logic:
            // 1. Element that was at index 0 (num[k-1]) moves to index n-1.
            // It already might have scored at index 0 (if nums[k-1] == 0).
            // If we just say "all rotations increase score by 1 because one item moves to
            // end",
            // and "change[k] tracks items that specifically dropped below their value", we
            // get it.
            currentScore = currentScore + 1 + change[k];
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }

        return bestK;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 2, 3, 1, 4, 0 };
        System.out.println("Result 1: " + sol.bestRotation(n1)); // 3

        int[] n2 = { 1, 3, 0, 2, 4 };
        System.out.println("Result 2: " + sol.bestRotation(n2)); // 0
    }
}
