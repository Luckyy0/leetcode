package leetcode.P868_BinaryGap;

class Solution {
    public int binaryGap(int n) {
        int maxDist = 0;
        int last = -1;
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                if (last != -1) {
                    maxDist = Math.max(maxDist, i - last);
                }
                last = i;
            }
        }
        return maxDist;
    }
}
