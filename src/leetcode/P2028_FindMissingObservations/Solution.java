package leetcode.P2028_FindMissingObservations;

import java.util.Arrays;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        long totalSum = (long) mean * (n + m);
        long currentSum = 0;
        for (int x : rolls)
            currentSum += x;

        long missingSum = totalSum - currentSum;

        if (missingSum < n || missingSum > 6L * n)
            return new int[0];

        int[] res = new int[n];
        int val = (int) (missingSum / n);
        int rem = (int) (missingSum % n);

        for (int i = 0; i < n; i++) {
            res[i] = val + (i < rem ? 1 : 0);
        }

        return res;
    }
}
