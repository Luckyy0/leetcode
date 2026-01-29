package leetcode.P957_PrisonCellsAfterNDays;

import java.util.*;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;
        int cycleLen = 0;

        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!seen.containsKey(key)) {
                seen.put(key, i);
            } else {
                hasCycle = true;
                cycleLen = i - seen.get(key);
                break;
            }
            cells = next;
        }

        if (hasCycle) {
            int remaining = (n - 1 - seen.get(Arrays.toString(cells))) % cycleLen;
            for (int i = 0; i < remaining; i++) {
                cells = nextDay(cells);
            }
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return next;
    }
}
