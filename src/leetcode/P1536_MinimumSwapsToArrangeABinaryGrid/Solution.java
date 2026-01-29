package leetcode.P1536_MinimumSwapsToArrangeABinaryGrid;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> zeros = new ArrayList<>();

        for (int[] row : grid) {
            int count = 0;
            for (int k = n - 1; k >= 0; k--) {
                if (row[k] == 0)
                    count++;
                else
                    break;
            }
            zeros.add(count);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int req = n - 1 - i;

            // Find nearest satisfying row
            int targetIdx = -1;
            for (int j = i; j < n; j++) {
                if (zeros.get(j) >= req) {
                    targetIdx = j;
                    break;
                }
            }

            if (targetIdx == -1)
                return -1;

            // Move targetIdx to i
            swaps += (targetIdx - i);
            int val = zeros.remove(targetIdx);
            zeros.add(i, val);
        }

        return swaps;
    }
}
