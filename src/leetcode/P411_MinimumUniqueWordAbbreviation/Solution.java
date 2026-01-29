package leetcode.P411_MinimumUniqueWordAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int minLen;
    private int bestMask;
    private int n;

    /**
     * Problem 411: Minimum Unique Word Abbreviation
     * Approach: Bitmask + Backtracking
     */
    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        List<Integer> diffMasks = new ArrayList<>();

        for (String word : dictionary) {
            if (word.length() != n)
                continue;
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (target.charAt(i) != word.charAt(i)) {
                    mask |= (1 << (n - 1 - i));
                }
            }
            diffMasks.add(mask);
        }

        if (diffMasks.isEmpty())
            return n + "";

        minLen = n + 1;
        bestMask = 0;

        dfs(0, 0, diffMasks);

        return maskToAbbr(target, bestMask);
    }

    private void dfs(int index, int currentMask, List<Integer> diffMasks) {
        int curLen = calculateLen(currentMask);
        if (curLen >= minLen)
            return; // Pruning

        // Check if currentMask satisfies all diffMasks
        boolean valid = true;
        for (int diff : diffMasks) {
            if ((currentMask & diff) == 0) {
                valid = false;
                break;
            }
        }

        if (valid) {
            minLen = curLen;
            bestMask = currentMask;
            return;
        }

        if (index == n)
            return;

        // Try to include char at index 'index'
        dfs(index + 1, currentMask | (1 << (n - 1 - index)), diffMasks);

        // Try skipping char at index 'index'
        // Only if we haven't found a valid solution yet or we need smaller
        dfs(index + 1, currentMask, diffMasks);
    }

    private int calculateLen(int mask) {
        int len = 0;
        int p = 0;
        while (p < n) {
            if ((mask & (1 << (n - 1 - p))) != 0) {
                len++;
                p++;
            } else {
                len++;
                while (p < n && (mask & (1 << (n - 1 - p))) == 0) {
                    p++;
                }
            }
        }
        return len;
    }

    private String maskToAbbr(String target, int mask) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (p < n) {
            if ((mask & (1 << (n - 1 - p))) != 0) {
                sb.append(target.charAt(p));
                p++;
            } else {
                int count = 0;
                while (p < n && (mask & (1 << (n - 1 - p))) == 0) {
                    count++;
                    p++;
                }
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // target = "apple", dictionary = ["blade"] -> "a4" (or other)
        System.out.println("Result: " + solution.minAbbreviation("apple", new String[] { "blade" }));

        // target = "apple", dictionary = ["plain", "amber", "blade"]
        System.out.println("Result: " + solution.minAbbreviation("apple", new String[] { "plain", "amber", "blade" }));
    }
}
