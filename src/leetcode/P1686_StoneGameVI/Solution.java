package leetcode.P1686_StoneGameVI;

import java.util.Arrays;

public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> (aliceValues[b] + bobValues[b]) - (aliceValues[a] + bobValues[a]));

        int score = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                score += aliceValues[indices[i]];
            } else {
                score -= bobValues[indices[i]];
            }
        }

        if (score > 0)
            return 1;
        if (score < 0)
            return -1;
        return 0;
    }
}
