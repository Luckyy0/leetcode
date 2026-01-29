package leetcode.P1611_MinimumOneBitOperationsToMakeIntegersZero;

public class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        // Find the most significant bit
        int k = 0;
        int temp = n;
        while ((temp >>= 1) > 0) {
            k++;
        }

        // Formula: cost(n) = (2^(k+1) - 1) - cost(n ^ 2^k)
        return ((1 << (k + 1)) - 1) - minimumOneBitOperations(n ^ (1 << k));
    }
}
