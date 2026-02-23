package leet_code.Problem_644_Hard_Maximum_Average_Subarray_II;

public class Solution_BinarySearchOnAnswer {

    /**
     * Finds the maximum average of a subarray of length >= k.
     * Strategy: Binary Search on the answer mid, check if any subarray sum (nums[i]
     * - mid) >= 0.
     * Time: O(N * log((max-min)/error)), Space: O(1).
     */
    public double findMaxAverage(int[] nums, int k) {
        double max_val = -10001;
        double min_val = 10001;
        for (int n : nums) {
            max_val = Math.max(max_val, n);
            min_val = Math.min(min_val, n);
        }

        double left = min_val, right = max_val;
        double error = 0.00001;

        while (right - left > error) {
            double mid = (left + right) / 2.0;
            if (check(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Checks if there's any subarray of length >= k with average >= mid.
     * Equivalent to checking if sum(nums[i] - mid) >= 0 for length >= k.
     */
    private boolean check(int[] nums, double mid, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }

        if (sum >= 0)
            return true;

        double prevSum = 0;
        double minPrevSum = 0;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prevSum += nums[i - k] - mid;
            minPrevSum = Math.min(minPrevSum, prevSum);

            // If current prefix sum - min prefix sum (at least k back) >= 0, we found it
            if (sum >= minPrevSum)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BinarySearchOnAnswer sol = new Solution_BinarySearchOnAnswer();
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println("Max average: " + sol.findMaxAverage(nums, k)); // 12.75
    }
}
