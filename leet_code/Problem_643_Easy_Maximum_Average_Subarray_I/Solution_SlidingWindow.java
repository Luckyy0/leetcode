package leet_code.Problem_643_Easy_Maximum_Average_Subarray_I;

public class Solution_SlidingWindow {

    /**
     * Finds the maximum average of a subarray of length k.
     * Strategy: Sliding Window to maintain the sum of k elements.
     * Time: O(N), Space: O(1).
     */
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the initial sum of the first k elements
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        // Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            // New element enters, old element leaves
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow sol = new Solution_SlidingWindow();
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println("Max average: " + sol.findMaxAverage(nums, k)); // 12.75
    }
}
