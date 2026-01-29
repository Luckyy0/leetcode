package leetcode.P888_FairCandySwap;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int x : aliceSizes)
            sumA += x;
        for (int x : bobSizes)
            sumB += x;

        int delta = (sumB - sumA) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : bobSizes)
            setB.add(x);

        for (int x : aliceSizes) {
            if (setB.contains(x + delta)) {
                return new int[] { x, x + delta };
            }
        }

        return new int[0];
    }
}
