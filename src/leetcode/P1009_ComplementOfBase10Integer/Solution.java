package leetcode.P1009_ComplementOfBase10Integer;

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;

        // Find mask of all 1s with same length
        int mask = n;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;

        return n ^ mask;
    }
}
