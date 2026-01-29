package leetcode.P1007_MinimumDominoRotationsForEqualRow;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int checkTop = check(tops[0], tops, bottoms, n);
        if (checkTop != -1 || tops[0] == bottoms[0])
            return checkTop;

        int checkBottom = check(bottoms[0], tops, bottoms, n);
        return checkBottom;
    }

    private int check(int x, int[] tops, int[] bottoms, int n) {
        int rotA = 0, rotB = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x)
                return -1;
            if (tops[i] != x)
                rotA++; // Need to swap to top
            if (bottoms[i] != x)
                rotB++; // Need to swap to bottom
        }
        return Math.min(rotA, rotB);
    }
}
