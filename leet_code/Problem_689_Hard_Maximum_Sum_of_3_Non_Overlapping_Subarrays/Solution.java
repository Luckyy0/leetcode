package leet_code.Problem_689_Hard_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

public class Solution {

    /**
     * Finds three non-overlapping subarrays of length k with maximum sum.
     * Strategy: Precompute best left and right indices relative to a middle window.
     * Time: O(N), Space: O(N).
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1; // number of possible windows
        int[] sums = new int[m];
        int currentSum = 0;

        // 1. Calculate every window sum of size k
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (i >= k)
                currentSum -= nums[i - k];
            if (i >= k - 1)
                sums[i - k + 1] = currentSum;
        }

        // 2. Precompute the best left index for each position
        int[] left = new int[m];
        int bestLeftIdx = 0;
        for (int i = 0; i < m; i++) {
            if (sums[i] > sums[bestLeftIdx]) {
                bestLeftIdx = i;
            }
            left[i] = bestLeftIdx;
        }

        // 3. Precompute the best right index for each position
        int[] right = new int[m];
        int bestRightIdx = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            // Use >= to ensure we pick the smallest index if sums are equal
            if (sums[i] >= sums[bestRightIdx]) {
                bestRightIdx = i;
            }
            right[i] = bestRightIdx;
        }

        // 4. Iterate through every possible middle window
        int[] result = new int[] { -1, -1, -1 };
        int maxTotal = 0;

        // Middle window index j must have space for length k on both sides
        // left: j-k, mid: j, right: j+k
        for (int j = k; j < m - k; j++) {
            int l = left[j - k];
            int r = right[j + k];
            int total = sums[l] + sums[j] + sums[r];

            if (total > maxTotal) {
                maxTotal = total;
                result[0] = l;
                result[1] = j;
                result[2] = r;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 2, 1, 2, 6, 7, 5, 1 };
        int[] res1 = sol.maxSumOfThreeSubarrays(nums1, 2);
        System.out.println("Indices: [" + res1[0] + ", " + res1[1] + ", " + res1[2] + "]"); // [0, 3, 5]
    }
}
