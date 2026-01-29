package leetcode.P829_ConsecutiveNumbersSum;

class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        // n = x + (x+1) + ... + (x+k-1)
        // n = kx + k(k-1)/2
        // kx = n - k(k-1)/2
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
        }
        return count;
    }
}
