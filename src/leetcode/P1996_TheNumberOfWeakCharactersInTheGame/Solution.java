package leetcode.P1996_TheNumberOfWeakCharactersInTheGame;

import java.util.Arrays;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // Sort: Attack Descending. If tie, Defense Ascending.
        Arrays.sort(properties, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0;
        int maxDef = 0;

        for (int[] p : properties) {
            if (p[1] < maxDef) {
                count++;
            }
            maxDef = Math.max(maxDef, p[1]);
        }

        return count;
    }
}
