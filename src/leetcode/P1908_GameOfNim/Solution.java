package leetcode.P1908_GameOfNim;

public class Solution {
    public boolean nimGame(int[] piles) {
        int xorSum = 0;
        for (int p : piles) {
            xorSum ^= p;
        }
        return xorSum != 0;
    }
}
