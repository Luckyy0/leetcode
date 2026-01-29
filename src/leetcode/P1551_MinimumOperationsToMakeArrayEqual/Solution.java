package leetcode.P1551_MinimumOperationsToMakeArrayEqual;

public class Solution {
    public int minOperations(int n) {
        // The target value is n.
        // The array is 1, 3, 5, ..., 2n-1.
        // We accumulate the difference between the target and the numbers smaller than
        // it.
        // This forms a sum of an arithmetic progression which simplifies to n^2 / 4.
        return n * n / 4;
    }
}
