package leetcode.P1375_NumberOfTimesBinaryStringIsPrefixAligned;

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int maxIndex = 0;
        int count = 0;
        int n = flips.length;

        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(maxIndex, flips[i]);
            // i starts from 0, so step is i + 1
            if (maxIndex == i + 1) {
                count++;
            }
        }

        return count;
    }
}
