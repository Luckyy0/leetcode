package leet_code.Problem_781_Medium_Rabbits_in_Forest;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Calculates the minimum number of rabbits in the forest.
     * Strategy: Count frequencies of answers. For each answer x, group rabbits into
     * batches of (x+1).
     * Time: O(N), Space: O(N).
     */
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        int totalRabbits = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();

            // Each group has size (x + 1)
            int groupSize = x + 1;

            // We need enough groups to cover 'count' rabbits.
            // Number of groups = ceil(count / groupSize)
            // Integer math trick for ceil(a/b): (a + b - 1) / b
            // Here: (count + groupSize - 1) / groupSize
            // Or simpler for this specific logic:
            // Since we count how many rabbits report 'x', say 5 rabbits report 2.
            // Group size is 3.
            // 3 rabbits form Group A (Red). 2 rabbits left must form Group B (Blue).
            // Total groups = 2. Total rabbits = 2 * 3 = 6.

            int numGroups = (count + groupSize - 1) / groupSize;
            totalRabbits += numGroups * groupSize;
        }

        return totalRabbits;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a1 = { 1, 1, 2 };
        System.out.println("Result 1: " + sol.numRabbits(a1)); // 5

        int[] a2 = { 10, 10, 10 };
        System.out.println("Result 2: " + sol.numRabbits(a2)); // 11
    }
}
