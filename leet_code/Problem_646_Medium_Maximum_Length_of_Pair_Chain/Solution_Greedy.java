package leet_code.Problem_646_Medium_Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

public class Solution_Greedy {

    /**
     * Finds the maximum length of a pair chain.
     * Strategy: Greedy - sort by the end of pairs and pick greedily.
     * Time: O(N log N), Space: O(1).
     */
    public int findLongestChain(int[][] pairs) {
        // Sort pairs by their 'right' element (end time)
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int count = 0;
        int currentEnd = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            // Check if this pair can follow the last pair in the chain
            if (pair[0] > currentEnd) {
                count++;
                currentEnd = pair[1]; // Update the end of the chain
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_Greedy sol = new Solution_Greedy();
        int[][] pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        System.out.println("Max chain length: " + sol.findLongestChain(pairs)); // 3
    }
}
