package leetcode.P1823_FindTheWinnerOfTheCircularGame;

public class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0; // 0-indexed for 1 person
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1; // Convert to 1-indexed
    }
}
