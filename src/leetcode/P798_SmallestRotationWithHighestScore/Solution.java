package leetcode.P798_SmallestRotationWithHighestScore;

class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] change = new int[n];

        for (int i = 0; i < n; i++) {
            // Element nums[i] stops being <= its index when k is (i - nums[i] + 1 + n) % n
            // Phan tu nums[i] thoi nho hon hoac bang chi so khi k = (i - nums[i] + 1 + n) %
            // n
            change[(i - nums[i] + 1 + n) % n]--;
        }

        int bestK = 0;
        int maxScore = -1;
        int currentScore = 0;

        // Initial score is hard to calculate relative to 0? Just use deltas.
        // Even better: every rotation K, one element moves from index 0 to N-1 (it
        // gains a point if nums[i] <= N-1)
        for (int k = 0; k < n; k++) {
            // Every increment of k, one element wraps from index 0 to n-1.
            // It always becomes scoring because nums[i] < n.
            currentScore += change[k] + 1;
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }

        return bestK;
    }
}
