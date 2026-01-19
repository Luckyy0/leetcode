package leetcode.P207_CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Problem 207: Course Schedule
     * Approach: Kahn's Algorithm (BFS based Topological Sort)
     * 
     * Theoretical Basis:
     * - Graph Cycle Detection using Indegrees.
     * - Nodes with 0 indegree can be "taken" (processed).
     * - If we can process all N nodes, it's a DAG (Directed Acyclic Graph).
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build Graph: [a, b] means b -> a
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // Add courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            coursesTaken++;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return coursesTaken == numCourses;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2, [[1,0]] -> true
        int[][] p1 = { { 1, 0 } };
        runTest(solution, 2, p1, true);

        // 2, [[1,0],[0,1]] -> false (Cycle)
        int[][] p2 = { { 1, 0 }, { 0, 1 } };
        runTest(solution, 2, p2, false);

        // 3, [[0,1], [0,2], [1,2]] -> true (2->1->0, 2->0)
        int[][] p3 = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        runTest(solution, 3, p3, true);
    }

    private static void runTest(Solution s, int num, int[][] prereqs, boolean expected) {
        boolean result = s.canFinish(num, prereqs);
        System.out.println("Courses: " + num + ", Prereqs: " + java.util.Arrays.deepToString(prereqs));
        System.out.println("Can Finish? " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
