package leetcode.P433_MinimumGeneticMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    /**
     * Problem 433: Minimum Genetic Mutation
     * Approach: Breadth-First Search (BFS)
     * 
     * Time Complexity: O(B * L * 4) where B is bank size, L is gene length (8)
     * Space Complexity: O(B)
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String b : bank)
            bankSet.add(b);

        if (!bankSet.contains(end))
            return -1;

        char[] genes = { 'A', 'C', 'G', 'T' };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end))
                    return level;

                char[] currArray = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = currArray[j];
                    for (char g : genes) {
                        currArray[j] = g;
                        String next = new String(currArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[j] = old;
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1 -> 1
        String start1 = "AACCGGTT";
        String end1 = "AACCGGTA";
        String[] bank1 = { "AACCGGTA" };
        runTest(sol, start1, end1, bank1, 1);

        // Example 2 -> 2
        String start2 = "AACCGGTT";
        String end2 = "AAACGGTA";
        String[] bank2 = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
        runTest(sol, start2, end2, bank2, 2);
    }

    private static void runTest(Solution sol, String start, String end, String[] bank, int expected) {
        int result = sol.minMutation(start, end, bank);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
