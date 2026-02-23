package leet_code.Problem_210_Medium_Course_Schedule_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_TopologicalSort {

    /**
     * Returns the topological ordering of courses.
     * Uses Kahn's Algorithm.
     * Time: O(V + E), Space: O(V + E).
     * 
     * Trả về thứ tự topo của các khóa học.
     * Sử dụng Thuật toán Kahn.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build Adjacency List and Indegree Array
        // 1. Xây dựng Danh sách kề và Mảng bậc vào
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int dependency = pair[1];
            adj.get(dependency).add(course);
            indegree[course]++;
        }

        // 2. Add courses with 0 indegree to Queue
        // 2. Thêm các khóa học có bậc vào 0 vào Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. Process the queue and build result array
        // 3. Xử lý hàng đợi và xây dựng mảng kết quả
        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check for cycle: if we didn't visit all courses, return empty array
        // Kiểm tra chu kỳ: nếu không thăm tất cả các khóa học, trả về mảng rỗng
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_TopologicalSort solution = new Solution_TopologicalSort();

        // Test Case 1: 2, [[1,0]] -> [0,1]
        int[] res1 = solution.findOrder(2, new int[][] { { 1, 0 } });
        System.out.println("Order 1: " + Arrays.toString(res1));

        // Test Case 2: 4, [[1,0],[2,0],[3,1],[3,2]] -> [0,1,2,3] or [0,2,1,3]
        int[] res2 = solution.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        System.out.println("Order 2: " + Arrays.toString(res2));

        // Test Case 3: 2, [[1,0],[0,1]] -> []
        int[] res3 = solution.findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
        System.out.println("Order 3: " + Arrays.toString(res3));
    }
}
