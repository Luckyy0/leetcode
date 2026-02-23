package leet_code.Problem_691_Hard_Stickers_to_Spell_Word;

import java.util.*;

public class Solution {

    /**
     * Finds the minimum number of stickers to spell out the target.
     * Strategy: Memoized recursion with character frequency sticker maps.
     * Optimization: Pick first character of target and only try stickers containing
     * it.
     * Time: O(2^L * S * L), Space: O(2^L).
     */
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        // Precompute character frequencies for each sticker
        int[][] stickerCounts = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        int result = solve(stickerCounts, target, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int[][] stickerCounts, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target))
            return memo.get(target);

        // Count characters in current target
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int minStickers = Integer.MAX_VALUE;

        // Find the first character needed in target to prune the search
        int firstCharIdx = target.charAt(0) - 'a';

        for (int[] sticker : stickerCounts) {
            // Optimization: Only use stickers that contain the first character needed
            if (sticker[firstCharIdx] > 0) {
                StringBuilder remaining = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (targetCount[i] > 0) {
                        // Subtract sticker's characters from current target needs
                        int countNeeded = Math.max(0, targetCount[i] - sticker[i]);
                        for (int j = 0; j < countNeeded; j++) {
                            remaining.append((char) ('a' + i));
                        }
                    }
                }

                int res = solve(stickerCounts, remaining.toString(), memo);
                if (res != Integer.MAX_VALUE) {
                    minStickers = Math.min(minStickers, 1 + res);
                }
            }
        }

        memo.put(target, minStickers);
        return minStickers;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] stickers1 = { "with", "example", "science" };
        System.out.println("Result (thehat): " + sol.minStickers(stickers1, "thehat")); // 3

        String[] stickers2 = { "notice", "possible" };
        System.out.println("Result (basicbasic): " + sol.minStickers(stickers2, "basicbasic")); // -1
    }
}
