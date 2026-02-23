package leet_code.Problem_207_Medium_Course_Schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_Kahn {

    /**
     * Determines if all courses can be finished.
     * Uses Kahn's Algorithm (Topological Sort with BFS).
     * Time: O(V + E), Space: O(V + E).
     * 
     * Xác định xem tất cả các khóa học có thể hoàn thành hay không.
     * Sử dụng Thuật toán Kahn (Sắp xếp Topo với BFS).
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            // dependency -> course
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

        // 3. Process the queue
        // 3. Xử lý hàng đợi
        int processedCount = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCount++;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we processed all courses, then no cycle exists
        // Nếu đã xử lý tất cả các khóa học, thì không có chu kỳ
        return processedCount == numCourses;
    }

    public static void main(String[] args) {
        Solution_Kahn solution = new Solution_Kahn();

        // Test Case 1: 2 courses, 1->0
        System.out.println("Can finish 2 courses [[1,0]]: " + solution.canFinish(2, new int[][] { { 1, 0 } }));

        // Test Case 2: 2 courses, 1->0 and 0->1
        System.out.println(
                "Can finish 2 courses [[1,0],[0,1]]: " + solution.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }
}
