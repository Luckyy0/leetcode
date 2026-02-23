package leet_code.Problem_786_Medium_K_th_Smallest_Prime_Fraction;

public class Solution {

    /**
     * Finds the K-th smallest prime fraction.
     * Strategy: Binary Search on the value of the fraction.
     * Time: O(N * log(1/epsilon)), Space: O(1).
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 1.0;

        while (low < high) {
            double mid = (low + high) / 2;

            // Count how many fractions are <= mid
            // Also track the maximum fraction <= mid (bestP / bestQ)
            int count = 0;
            int bestP = 0, bestQ = 1;
            int i = 0; // Numerator index

            // Two pointers sliding window
            // For each denominator arr[j], find how many numerators arr[i] satisfy
            // arr[i]/arr[j] <= mid
            // Rewritten: arr[i] <= mid * arr[j]
            for (int j = 1; j < n; j++) {
                while (i < j && arr[i] <= mid * arr[j]) {
                    i++;
                }
                count += i;

                // If we found valid numerators (i > 0), the largest one is arr[i-1]
                // Check if arr[i-1]/arr[j] is the new max fraction we've seen
                if (i > 0) {
                    if (bestP == 0 || arr[i - 1] * bestQ > bestP * arr[j]) { // Cross multiply comparison
                        bestP = arr[i - 1];
                        bestQ = arr[j];
                    }
                }
            }

            if (count == k) {
                return new int[] { bestP, bestQ };
            } else if (count < k) {
                low = mid;
            } else {
                // If count > k, the true K-th value is smaller than mid.
                // However, the 'bestP/bestQ' we found *might* be the K-th value
                // if the distribution is sparse.
                // But generally typical BS: high = mid.
                high = mid;
            }
            // Since we compare doubles, strictly 'count == k' might be hard to hit due to
            // continuous range logic?
            // Actually, because we return the exact fraction 'bestP/bestQ' found below
            // 'mid',
            // AND we adjust bounds, we might need a distinct termination check.
            // But a standard trick with float BS for discrete answers:
            // Just loop fixed times, or check range.
            // WITH discrete count, if count == k, 'bestP/bestQ' is indeed the K-th largest
            // among those count.
            // Wait, if count > k, we have too many. The K-th is smaller.
            // The max fraction we found is simply the largest <= mid.
            // If count == k, the largest <= mid IS the K-th.
            // Why? Because there are exactly K fractions <= mid, and 'best' is the largest
            // of them.
            // So it must be the K-th smallest.
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = { 1, 2, 3, 5 };
        int[] res1 = sol.kthSmallestPrimeFraction(arr1, 3);
        System.out.println("Result 1: [" + res1[0] + ", " + res1[1] + "]"); // [2, 5]

        int[] arr2 = { 1, 7 };
        int[] res2 = sol.kthSmallestPrimeFraction(arr2, 1);
        System.out.println("Result 2: [" + res2[0] + ", " + res2[1] + "]"); // [1, 7]
    }
}
