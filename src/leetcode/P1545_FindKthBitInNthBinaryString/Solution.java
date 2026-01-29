package leetcode.P1545_FindKthBitInNthBinaryString;

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';

        int len = (1 << n) - 1;
        int mid = len / 2 + 1;

        if (k == mid)
            return '1';
        if (k < mid)
            return findKthBit(n - 1, k);

        // Right side: reverse(invert(Si-1))
        // Map k to index in Si-1.
        // Index in reversed part corresponds to len - k + 1 in original Si-1
        char val = findKthBit(n - 1, len - k + 1);
        return val == '0' ? '1' : '0';
    }
}
