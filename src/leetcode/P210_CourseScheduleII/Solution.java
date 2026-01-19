package leetcode.P210_CourseScheduleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Problem 210: Course Schedule II
     * Approach: Kahn's Algorithm (BFS Topological Sort)
     * 
     * Theoretical Basis:
     * - Collect nodes as their indegree becomes 0.
     * - This guarantees any prerequisite appeared before dependent course.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we picked all courses, return order. Otherwise cycle exists.
        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2, [[1,0]] -> [0, 1]
        int[][] p1 = { { 1, 0 } };
        runTest(solution, 2, p1);

        // 4, [[1,0],[2,0],[3,1],[3,2]] -> [0, 1, 2, 3] or [0, 2, 1, 3]
        int[][] p2 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        runTest(solution, 4, p2);

        // 2, [[1,0],[0,1]] -> []
        int[][] p3 = { { 1, 0 }, { 0, 1 } };
        runTest(solution, 2, p3);
    }

    private static void runTest(Solution s, int num, int[][] prereqs) {
        int[] result = s.findOrder(num, prereqs);
        System.out.println("Courses: " + num + ", Prereqs: " + Arrays.deepToString(prereqs));
        System.out.println("Order: " + Arrays.toString(result));
        System.out.println("-----------------");
    }
}
