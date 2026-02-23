package leet_code.Problem_877_Medium_Stone_Game;

/**
 * Problem 877: Stone Game
 * https://leetcode.com/problems/stone-game/
 */
public class Solution {

    /**
     * Determines if Alice wins the stone game.
     * Strategy: Mathematical proof or Dynamic Programming.
     * 
     * @param piles Array of stone counts in each pile.
     * @return True if Alice wins.
     * 
     *         Tóm tắt chiến lược:
     *         1. Phân tích toán học: Vì có số nải chẵn và tổng số lẻ, Alice luôn có
     *         thể
     *         chọn lấy tất cả các nải ở vị trí chẵn hoặc tất cả các nải ở vị trí
     *         lẻ.
     *         Bằng cách so sánh hai tổng này, Alice luôn có thể chọn chiến thuật để
     *         thắng.
     *         2. Phân tích DP: dp[i][j] = sự chênh lệch điểm tối đa từ nải i đến j.
     *         dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]).
     */
    public boolean stoneGame(int[] piles) {
        // Based on the game theory for an even number of piles with an
        // odd total sum, the first player can always pick a strategy to win.
        return true;
    }

    /*
     * Optional DP implementation for educational purposes:
     * public boolean stoneGameDP(int[] piles) {
     * int n = piles.length;
     * int[][] dp = new int[n][n];
     * for (int i = 0; i < n; i++) dp[i][i] = piles[i];
     * for (int d = 1; d < n; d++) {
     * for (int i = 0; i < n - d; i++) {
     * int j = i + d;
     * dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
     * }
     * }
     * return dp[0][n - 1] > 0;
     * }
     */

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] piles = { 5, 3, 4, 5 };
        System.out.println("Alice wins: " + sol.stoneGame(piles)); // true
    }
}
