package leet_code.Problem_506_Easy_Relative_Ranks;

import java.util.Arrays;

public class Solution_Sorting {

    /**
     * Assigns ranks based on scores.
     * Strategy: Sort indices based on score values descending.
     * Time: O(N log N), Space: O(N).
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        // Sort indices descending by score
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = indices[i];
            if (i == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Sorting solution = new Solution_Sorting();
        int[] score = { 10, 3, 8, 9, 4 };
        String[] res = solution.findRelativeRanks(score);

        System.out.print("Result: [");
        for (int i = 0; i < res.length; i++) {
            System.out.print("\"" + res[i] + "\"" + (i < res.length - 1 ? ", " : ""));
        }
        System.out.println("]"); // ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
    }
}
