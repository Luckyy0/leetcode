package leetcode.P2029_StoneGameIX;

public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] counts = new int[3];
        for (int x : stones)
            counts[x % 3]++;

        if (counts[0] % 2 == 0) {
            // Even 0s: Alice wins if min(c1, c2) >= 1
            return counts[1] >= 1 && counts[2] >= 1;
        } else {
            // Odd 0s: Alice wins if abs(c1 - c2) > 2
            return Math.abs(counts[1] - counts[2]) > 2;
        }
    }
}
