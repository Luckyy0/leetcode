package leetcode.P1573_NumberOfWaysToSplitAString;

public class Solution {
    public int numWays(String s) {
        long n = s.length();
        long ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
        }

        long MOD = 1_000_000_007;

        if (ones == 0) {
            // formula: (n-1)*(n-2)/2
            return (int) (((n - 1) * (n - 2) / 2) % MOD);
        }

        if (ones % 3 != 0) {
            return 0;
        }

        long target = ones / 3;
        long ways1 = 0;
        long ways2 = 0;
        long count = 0;

        // We can just iterate and count zeros between the blocks of 1s
        // Or store indices. Since n is up to 10^5, iterating is fine.

        // Find indices of relevant 1s
        // We need the index of:
        // k-th 1 (last of 1st block)
        // (k+1)-th 1 (first of 2nd block) -> difference gives ways1
        // 2k-th 1 (last of 2nd block)
        // (2k+1)-th 1 (first of 3rd block) -> difference gives ways2

        long countOnes = 0;
        // Looking for gap 1: between target and target+1
        // Looking for gap 2: between 2*target and 2*target+1

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }
            if (countOnes == target) {
                ways1++;
            } else if (countOnes == 2 * target) {
                ways2++;
            }
        }

        // Note: The logic above counts the '0's + the '1' that ends the block?
        // Let's trace.
        // Example: 10101, target 1.
        // i=0 ('1'), count=1. ways1++. (Correct, split after index 0 is valid).
        // i=1 ('0'), count=1. ways1++. (Correct, split after index 1 is valid).
        // i=2 ('1'), count=2. ways1 stops.
        // So ways1 is correct count of valid split positions for first cut.

        return (int) ((ways1 * ways2) % MOD);
    }
}
