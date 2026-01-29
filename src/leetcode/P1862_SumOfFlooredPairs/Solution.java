package leetcode.P1862_SumOfFlooredPairs;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumOfFlooredPairs(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] counts = new int[maxVal + 1];
        for (int num : nums) {
            counts[num]++;
        }

        int[] prefix = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefix[i] = prefix[i - 1] + counts[i];
        }

        long totalSum = 0;

        for (int y = 1; y <= maxVal; y++) {
            if (counts[y] == 0)
                continue;

            long currentSum = 0;
            // Iterate multiples of y
            for (long j = y; j <= maxVal; j += y) {
                int lower = (int) j;
                int upper = (int) Math.min(j + y - 1, maxVal);

                int countInRange = prefix[upper] - prefix[lower - 1];
                long contribution = (j / y); // value of floor(x/y) for this range

                currentSum = (currentSum + contribution * countInRange) % MOD;
            }

            // Multiply by frequency of y
            totalSum = (totalSum + currentSum * counts[y]) % MOD;
        }

        return (int) totalSum;
    }
}
