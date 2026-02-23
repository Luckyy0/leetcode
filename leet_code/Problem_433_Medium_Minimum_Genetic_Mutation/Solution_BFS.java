package leet_code.Problem_433_Medium_Minimum_Genetic_Mutation;

import java.util.*;

public class Solution_BFS {

    /**
     * Finds the minimum number of mutations from start to end gene.
     * Strategy: BFS on graph of valid mutations.
     * Time: O(8 * 4 * B), Space: O(B).
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        char[] choices = { 'A', 'C', 'G', 'T' };
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process each level
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene))
                    return steps;

                char[] currArr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char originalChar = currArr[j];
                    for (char c : choices) {
                        if (c == originalChar)
                            continue;

                        currArr[j] = c;
                        String mutation = new String(currArr);

                        if (bankSet.contains(mutation) && !visited.contains(mutation)) {
                            visited.add(mutation);
                            queue.offer(mutation);
                        }
                    }
                    currArr[j] = originalChar; // backtracking
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = { "AACCGGTA", "AAACGGTA", "AACCCTA" };

        System.out.println("Result: " + solution.minMutation(start, end, bank)); // 2
    }
}
