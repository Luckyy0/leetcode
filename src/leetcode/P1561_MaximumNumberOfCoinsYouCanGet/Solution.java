package leetcode.P1561_MaximumNumberOfCoinsYouCanGet;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int maxCoins = 0;

        // We start picking from the index n (skipping the smallest n elements)
        // And pick every second element going upwards to 3n-2
        // Actually, easiest is:
        // Piles: [S1, S2, ... Sn, M1, L1, M2, L2, ... Mn, Ln]
        // You get Mi.
        // In sorted array:
        // Index: 0 ... n-1 (Smallest, give to Bob)
        // Index: n ... 3n-1 (Large ones)
        // From the large pool, we pick pairs.
        // 3n-2 is the second largest of top pair. 3n-4 is second largest of next pair.
        // We pick n times.

        for (int i = piles.length - 2; i >= n; i -= 2) {
            maxCoins += piles[i];
        }

        return maxCoins;
    }
}
