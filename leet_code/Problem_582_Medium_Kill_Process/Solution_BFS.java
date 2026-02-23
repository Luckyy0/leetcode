package leet_code.Problem_582_Medium_Kill_Process;

import java.util.*;

public class Solution_BFS {

    /**
     * Finds all processes that will be killed.
     * Strategy: Adjacency map + Breadth-First Search (BFS).
     * Time: O(N), Space: O(N).
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Build adjacency map: parent -> list of children
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start traversal from the targeted process
        queue.add(kill);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // Add all direct children of the current process to the queue
            List<Integer> children = adj.get(current);
            if (children != null) {
                queue.addAll(children);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        System.out.println("Processes killed: " + solution.killProcess(pid, ppid, 5)); // [5, 10]
    }
}
