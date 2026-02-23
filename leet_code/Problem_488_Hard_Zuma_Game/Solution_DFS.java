package leet_code.Problem_488_Hard_Zuma_Game;

import java.util.HashMap;
import java.util.Map;

public class Solution_DFS {

    private int minBalls = Integer.MAX_VALUE;

    /**
     * Finds min balls to clear the board.
     * Strategy: DFS with pruning. Try inserting balls to complete groups.
     * Time: Exponential, but bounded by hand size.
     */
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handMap = new HashMap<>();
        for (char c : hand.toCharArray()) {
            handMap.put(c, handMap.getOrDefault(c, 0) + 1);
        }

        dfs(board, handMap, 0);

        return minBalls == Integer.MAX_VALUE ? -1 : minBalls;
    }

    private void dfs(String board, Map<Character, Integer> hand, int used) {
        if (board.isEmpty()) {
            minBalls = Math.min(minBalls, used);
            return;
        }

        if (used >= minBalls)
            return; // Pruning

        // Iterate through the board to find insertion points
        for (int i = 0; i < board.length(); i++) {
            // Optimization: Only attempt to insert at the START of a consecutive group
            // i.e., skip if previous char is same color
            if (i > 0 && board.charAt(i) == board.charAt(i - 1))
                continue;

            char color = board.charAt(i);
            int j = i;
            while (j < board.length() && board.charAt(j) == color)
                j++;

            int streak = j - i; // Number of existing balls of 'color'
            int needed = 3 - streak; // Needed to clear (at least)

            if (hand.getOrDefault(color, 0) >= Math.max(0, needed)) {
                // Determine actual used. If streak >= 3 (not possible initially but during
                // recursion maybe?), needed <= 0.
                // But generally needed is 1 or 2.
                int cost = Math.max(0, needed);

                // Update hand
                hand.put(color, hand.get(color) - cost);

                // Construct new board
                // Removing substring [i, j) simulates adding balls and clearing.
                // But wait, removing happens AFTER collapse.
                // So efficiently, we just form NEW board string by skipping this group [i, j)
                // because we assume we added 'needed' balls to make it disappear.

                String nextBoard = collapse(board.substring(0, i) + board.substring(j));

                dfs(nextBoard, hand, used + cost);

                // Backtrack
                hand.put(color, hand.get(color) + cost);
            }
        }
    }

    // Helper to simulate chain reaction collapses
    private String collapse(String board) {
        // Repeatedly remove groups of 3+
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i))
                j++;
            if (j - i >= 3) {
                return collapse(board.substring(0, i) + board.substring(j));
            }
            i = j; // Move to next group
        }
        return board;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        System.out.println("Result 1: " + solution.findMinStep("WRRBBW", "RB")); // -1

        // Re-instantiate for clean state
        solution = new Solution_DFS();
        System.out.println("Result 2: " + solution.findMinStep("WWRRBBWW", "WRBRW")); // 2
    }
}
