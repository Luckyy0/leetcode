package leetcode.P1854_MaximumPopulationYear;

public class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[102]; // 1950 to 2050 (inclusive? max date 2050 usually limit)
        // Range 1950..2050. Size 101. +1 for boundary.

        for (int[] log : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        int maxPop = 0;
        int maxYear = 1950;
        int currPop = 0;

        for (int i = 0; i <= 100; i++) {
            currPop += diff[i];
            if (currPop > maxPop) {
                maxPop = currPop;
                maxYear = 1950 + i;
            }
        }

        return maxYear;
    }
}
