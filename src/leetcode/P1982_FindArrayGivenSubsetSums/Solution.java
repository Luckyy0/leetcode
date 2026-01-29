package leetcode.P1982_FindArrayGivenSubsetSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int[] res = new int[n];
        divide(sums, res, 0);
        return res;
    }

    private void divide(int[] sums, int[] res, int idx) {
        if (sums.length == 1)
            return; // Base case n=0 basically, leaving [0] (or shifted 0)

        int n = sums.length;
        int d = sums[1] - sums[0]; // Absolute difference

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        boolean[] used = new boolean[n];

        // Partition into (x, x+d) pairs
        // Since sorted, we iterate. If not used, it's x. Then find x+d.
        // x is always current smallest unused.

        // Pointer optimization:
        // 'k' points to potential x+d.
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                // sums[i] is 'x' (smaller of pair)
                int x = sums[i];
                // Find x+d. Since sorted, x+d is at some index >= i+1.
                // We use a pointer to find it efficiently.
                if (k <= i)
                    k = i + 1;
                while (k < n && (used[k] || sums[k] != x + d)) {
                    k++;
                }
                // sums[k] is pair
                used[i] = true;
                used[k] = true;

                left.add(sums[i]);
                right.add(sums[k]);
            }
        }

        // Check which set contains 0
        boolean zeroInLeft = false;
        for (int val : left)
            if (val == 0) {
                zeroInLeft = true;
                break;
            }

        int[] nextSums = new int[n / 2];

        if (zeroInLeft) {
            res[idx] = d;
            for (int i = 0; i < n / 2; i++)
                nextSums[i] = left.get(i);
        } else {
            res[idx] = -d;
            for (int i = 0; i < n / 2; i++)
                nextSums[i] = right.get(i);
        }

        divide(nextSums, res, idx + 1);
    }
}
