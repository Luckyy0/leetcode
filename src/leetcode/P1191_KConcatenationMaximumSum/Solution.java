package leetcode.P1191_KConcatenationMaximumSum;

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long mod = 1_000_000_007;

        long currentSum = 0;
        long maxSub = 0; // Can be 0 if all neg and we pick empty
        long totalSum = 0;

        for (int x : arr)
            totalSum += x;

        // Run Kadane on arr * 2 (or arr if k=1)
        int loop = k > 1 ? 2 : 1;

        for (int i = 0; i < loop * arr.length; i++) {
            int val = arr[i % arr.length];
            currentSum = Math.max(0, currentSum + val);
            maxSub = Math.max(maxSub, currentSum);
        }

        if (k > 2 && totalSum > 0) {
            maxSub = (maxSub + (long) (k - 2) * totalSum) % mod;
        }

        return (int) (maxSub % mod);
    }
}
