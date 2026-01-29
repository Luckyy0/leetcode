package leetcode.P1304_FindNUniqueIntegersSumUpToZero;

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx = 0;

        // Add pairs
        for (int i = 1; i <= n / 2; i++) {
            res[idx++] = i;
            res[idx++] = -i;
        }

        // If odd, one spot left, default 0 is fine.
        return res;
    }
}
