package leetcode.P644_MaximumAverageSubarrayII;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double left = -10000;
        double right = 10000;

        while (right - left > 0.00001) {
            double mid = (left + right) / 2;
            if (check(nums, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean check(int[] nums, int k, double avg) {
        double minSum = 0;
        double currentSum = 0;
        double prevSum = 0; // sum of (nums[i] - avg) for prefix i-k

        // We want to find subarray [i, j] with length >= k such that sum >= 0 (after
        // subtracting avg)
        // Let b[x] = nums[x] - avg.
        // We calculate prefix sums of b. S[j] - S[i] >= 0 where j - i >= k.
        // S[j] >= S[i]. We want max S[j] - S[i].
        // So for each j, we subtract min S[i] where i <= j - k.

        double[] b = new double[nums.length];
        for (int i = 0; i < nums.length; i++)
            b[i] = nums[i] - avg;

        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] = prefix[i] + b[i];

        // Iterate j from k to n
        // j corresponds to prefix index, so prefix[j] is sum of b[0]..b[j-1] (length j)
        double minPrefix = 0;
        for (int j = k; j <= nums.length; j++) {
            // Valid subarray ends at j-1 (length j)
            // Starts at i. Length j-i >= k. So i <= j-k.
            // minPrefix tracks min(prefix[0] ... prefix[j-k])

            if (prefix[j] - minPrefix >= 0)
                return true;

            // Update minPrefix for next step
            // Next step j+1, we can include prefix[j-k+1] in potential min
            if (j - k + 1 <= nums.length) // Actually just check prefix[j-k+1] next time
                minPrefix = Math.min(minPrefix, prefix[j - k + 1]);
        }
        return false;
    }
}
