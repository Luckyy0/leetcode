package leetcode.P691_StickersToSpellWord;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] stickerCounts = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray())
                stickerCounts[i][c - 'a']++;
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        return dfs(stickerCounts, target, memo);
    }

    private int dfs(int[][] stickerCounts, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target))
            return memo.get(target);

        int[] targetCount = new int[26];
        for (char c : target.toCharArray())
            targetCount[c - 'a']++;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickerCounts.length; i++) {
            // Optimization: If current sticker doesn't have the first character of target,
            // skip.
            // Tối ưu hóa: Nếu nhãn dán hiện tại không có ký tự đầu tiên của mục tiêu, hãy
            // bỏ qua.
            if (stickerCounts[i][target.charAt(0) - 'a'] <= 0)
                continue;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetCount[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetCount[j] - stickerCounts[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }

            int res = dfs(stickerCounts, sb.toString(), memo);
            if (res != -1)
                min = Math.min(min, 1 + res);
        }

        memo.put(target, min == Integer.MAX_VALUE ? -1 : min);
        return memo.get(target);
    }
}
