package leet_code.Problem_752_Medium_Open_the_Lock;

import java.util.*;

public class Solution {

    /**
     * Finds min turns to open the lock.
     * Strategy: BFS for shortest path in unweighted graph.
     * Time: O(10000 * 8), Space: O(10000).
     */
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        // Corner case: start is a deadend
        if (dead.contains("0000")) {
            return -1;
        }

        // BFS Initialization
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        visited.addAll(dead); // Treat deadends as visited to avoid exploring them

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                // Generate 8 possible moves
                for (int j = 0; j < 4; j++) {
                    char c = current.charAt(j);

                    // Move Up (+1)
                    String s1 = current.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + current.substring(j + 1);
                    if (visited.add(s1)) {
                        queue.offer(s1);
                    }

                    // Move Down (-1)
                    String s2 = current.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + current.substring(j + 1);
                    if (visited.add(s2)) {
                        queue.offer(s2);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] dead1 = { "0201", "0101", "0102", "1212", "2002" };
        System.out.println("Result 1: " + sol.openLock(dead1, "0202")); // 6

        String[] dead2 = { "8888" };
        System.out.println("Result 2: " + sol.openLock(dead2, "0009")); // 1
    }
}
