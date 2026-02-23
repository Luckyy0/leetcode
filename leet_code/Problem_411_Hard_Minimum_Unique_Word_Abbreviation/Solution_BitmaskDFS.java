package leet_code.Problem_411_Hard_Minimum_Unique_Word_Abbreviation;

import java.util.*;

public class Solution_BitmaskDFS {

    private int minLen;
    private int bestMask;
    private List<Integer> dictMasks;
    private int m;

    /**
     * Finds the shortest unique abbreviation of target.
     * Uses bitmask representations and DFS with pruning.
     * Time: O(2^m), Space: O(filtered_dict_size).
     * 
     * Tìm từ viết tắt duy nhất ngắn nhất của target.
     * Sử dụng biểu diễn bitmask và DFS với kỹ thuật cắt tỉa.
     */
    public String minAbbreviation(String target, String[] dictionary) {
        m = target.length();
        dictMasks = new ArrayList<>();

        // Filter dictionary by length and convert to bitmasks
        // Lọc từ điển theo độ dài và chuyển sang bitmask
        for (String word : dictionary) {
            if (word.length() != m)
                continue;
            int mask = 0;
            for (int i = 0; i < m; i++) {
                if (target.charAt(i) != word.charAt(i)) {
                    mask |= (1 << (m - 1 - i));
                }
            }
            dictMasks.add(mask);
        }

        if (dictMasks.isEmpty())
            return String.valueOf(m);

        minLen = m + 1;
        bestMask = (1 << m) - 1;

        // DFS to find the best mask
        // DFS để tìm mask tốt nhất
        dfs(0, 0);

        return constructAbbr(target, bestMask);
    }

    private void dfs(int index, int currentMask) {
        int currentLen = getLen(currentMask, m);
        if (currentLen >= minLen)
            return;

        // Check if current mask is valid for all dict words
        // Kiểm tra xem mask hiện tại có giải quyết được mọi từ trong từ điển không
        boolean valid = true;
        for (int dMask : dictMasks) {
            if ((currentMask & dMask) == 0) {
                valid = false;
                break;
            }
        }

        if (valid) {
            minLen = currentLen;
            bestMask = currentMask;
            return;
        }

        if (index == m)
            return;

        // Try keeping the bit at 'index'
        // Thử giữ bit tại vị trí 'index'
        dfs(index + 1, currentMask | (1 << (m - 1 - index)));

        // Try skipping the bit at 'index'
        // (Length check already pruned above)
        dfs(index + 1, currentMask);
    }

    private int getLen(int mask, int n) {
        int len = n;
        for (int i = 0; i < n - 1; i++) {
            if (((mask >> i) & 3) == 0)
                len--;
        }
        return len;
    }

    private String constructAbbr(String target, int mask) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (((mask >> (m - 1 - i)) & 1) == 1) {
                if (count > 0) {
                    sb.append(count);
                    count = 0;
                }
                sb.append(target.charAt(i));
            } else {
                count++;
            }
        }
        if (count > 0)
            sb.append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_BitmaskDFS solution = new Solution_BitmaskDFS();

        // Example 1
        System.out.println("Result 1: " + solution.minAbbreviation("apple", new String[] { "blade" }));

        // Example 2
        System.out
                .println("Result 2: " + solution.minAbbreviation("apple", new String[] { "plain", "amber", "blade" }));
    }
}
