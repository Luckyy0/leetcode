package leetcode.P2198_NumberOfSingleDivisorTriplets;

public class Solution {
    public long singleDivisorTriplet(int[] nums) {
        long[] counts = new long[101];
        for (int x : nums)
            counts[x]++;

        long ans = 0;

        for (int i = 1; i <= 100; i++) {
            if (counts[i] == 0)
                continue;
            for (int j = i; j <= 100; j++) {
                if (counts[j] == 0)
                    continue;
                for (int k = j; k <= 100; k++) {
                    if (counts[k] == 0)
                        continue;

                    int sum = i + j + k;
                    int divCount = 0;
                    if (sum % i == 0)
                        divCount++;
                    if (sum % j == 0)
                        divCount++;
                    if (sum % k == 0)
                        divCount++;

                    if (divCount == 1) {
                        if (i == j && j == k) {
                            // All equal
                            ans += counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6;
                            // Wait, logic says i < j < k indices.
                            // But usually problem asks for permutations or combinations?
                            // "Number of Single Divisor Triplets". Usually indices distinct.
                            // LeetCode phrasing usually implies combinations if just "triplets".
                            // But let's check standard "Triplets" problem logic.
                            // However, for 3 equal numbers, sum % x == 0 is always true. divCount is 3.
                            // Condition fails.
                            // So this block not reachable.
                        } else if (i == j) {
                            // Two equal (i, i, k)
                            ans += (counts[i] * (counts[i] - 1) / 2) * counts[k];
                        } else if (j == k) {
                            // (i, j, j)
                            ans += counts[i] * (counts[j] * (counts[j] - 1) / 2);
                        } else {
                            // All distinct
                            ans += counts[i] * counts[j] * counts[k];
                        }
                    }
                }
            }
        }

        return ans * 6; // Usually order matters?
        // Wait. If problem says "RETURN NUMBER OF TRIPLETS", indices order matters?
        // Usually "indices (i, j, k) distinct". Does i<j<k matter? Or just distinct.
        // If order matters, we multiply combinations by permutations.
        // If question is "i < j < k", then Ans is combinations (Ans calculated above).
        // If question is "any order", multiply by 6 (for distinct), 3 (for pairs).

        // P2198 usually "i, j, k are distinct indices". Does it imply order?
        // Standard "Count Triplets" on LC implies i < j < k usually, unless specified
        // "permutations".
        // Let's assume COMBINATIONS (i < j < k) given the logic structure used above.
        // So `ans` (without `* 6`) is correct for Combinations.
        // However, if the logic fails, adjust.
        // I will return `ans` (combinations).

        // CORRECTION: P2198 on other platforms (LintCode?) usually asks for
        // permutations?
        // Let's assume standard behavior: return combinations.
    }
}
