package leetcode.P1033_MovingStonesUntilConsecutive;

import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] s = { a, b, c };
        Arrays.sort(s);

        int x = s[0], y = s[1], z = s[2];

        // Max moves
        int maxMoves = (y - x - 1) + (z - y - 1);

        // Min moves
        int minMoves;
        if (z - x == 2) {
            minMoves = 0;
        } else if (y - x <= 2 || z - y <= 2) {
            minMoves = 1;
        } else {
            minMoves = 2;
        }

        return new int[] { minMoves, maxMoves };
    }
}
