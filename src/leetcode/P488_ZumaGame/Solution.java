package leetcode.P488_ZumaGame;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 488: Zuma Game
     * Approach: DFS with Memoization
     */
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray())
            handCount[c - 'A']++;

        int result = dfs(board, handCount, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String board, int[] hand, Map<String, Integer> memo) {
        board = removeGroups(board);
        if (board.isEmpty())
            return 0;

        String state = board + serializeHand(hand);
        if (memo.containsKey(state))
            return memo.get(state);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (hand[j] > 0) {
                    // Optimized: Only insert if color matches or if it can create a group
                    // Here we'll take a simpler approach for the mock test
                    hand[j]--;
                    int res = dfs(board.substring(0, i) + (char) ('A' + j) + board.substring(i), hand, memo);
                    if (res != Integer.MAX_VALUE) {
                        min = Math.min(min, 1 + res);
                    }
                    hand[j]++;
                }
            }
        }

        memo.put(state, min);
        return min;
    }

    private String removeGroups(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                return removeGroups(board.substring(0, i) + board.substring(j));
            }
            i = j;
        }
        return board;
    }

    private String serializeHand(int[] hand) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (hand[i] > 0) {
                sb.append((char) ('A' + i)).append(hand[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // board = "WRRBBW", hand = "RB" -> -1
        System.out.println("Result: " + sol.findMinStep("WRRBBW", "RB"));

        // board = "WWRRBBWW", hand = "WRB" -> 2
        // WWRRBBWW -> Insert R -> WWRRRBBWW -> WWBBWW -> Insert B -> WWBBBWW -> WWWW ->
        // empty
        // System.out.println("Result: " + sol.findMinStep("WWRRBBWW", "WRB"));
    }
}
