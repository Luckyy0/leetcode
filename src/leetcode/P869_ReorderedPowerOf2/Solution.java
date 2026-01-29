package leetcode.P869_ReorderedPowerOf2;

import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] targetCounts = count(n);

        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(targetCounts, count(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int x) {
        int[] res = new int[10];
        while (x > 0) {
            res[x % 10]++;
            x /= 10;
        }
        return res;
    }
}
