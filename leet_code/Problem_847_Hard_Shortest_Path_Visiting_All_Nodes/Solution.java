package leet_code.Problem_847_Hard_Shortest_Path_Visiting_All_Nodes;

import java.util.*;

/**
 * Problem 847: Shortest Path Visiting All Nodes
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 */
public class Solution {

    /**
     * Finds the length of the shortest path visiting all nodes.
     * Strategy: BFS with Bitmask.
     * 
     * @param graph Adjacency list of the graph.
     * @return Minimum distance.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng thuật toán Tìm kiếm theo chiều rộng (BFS) để tìm đường đi
     *         ngắn nhất.
     *         2. Trạng thái trong BFS bao gồm: (nút hiện tại, mặt nạ bit đại diện
     *         cho tập hợp nút đã ghé thăm).
     *         3. Khởi tạo: Thêm tất cả các nút vào hàng đợi BFS với mặt nạ bit ban
     *         đầu
     *         chỉ có nút đó được bật. Điều này cho phép bắt đầu từ bất kỳ đâu.
     *         4. Sử dụng mảng seen[n][1 << n] để tránh lặp lại cùng một trạng thái
     *         (nút, mặt nạ).
     *         5. Đích đến: Khi mặt nạ bit có tất cả các bit là 1 (tức là 1 << n -
     *         1),
     *         ta đã thăm tất cả các nút. Khoảng cách hiện tại chính là đáp án.
     */
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1)
            return 0;

        int allVisitedMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];

        // Add all nodes as starting points
        for (int i = 0; i < n; i++) {
            queue.add(new int[] { i, 1 << i, 0 }); // current, mask, dist
            seen[i][1 << i] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int mask = current[1];
            int dist = current[2];

            // Check if all nodes are visited
            if (mask == allVisitedMask) {
                return dist;
            }

            // Explore neighbors
            for (int v : graph[u]) {
                int nextMask = mask | (1 << v);
                if (!seen[v][nextMask]) {
                    seen[v][nextMask] = true;
                    queue.add(new int[] { v, nextMask, dist + 1 });
                }
            }
        }

        return -1; // Should not reach here for a connected graph
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
        System.out.println("Min dist: " + sol.shortestPathLength(g1)); // 4

        int[][] g2 = { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
        System.out.println("Min dist: " + sol.shortestPathLength(g2)); // 4
    }
}
