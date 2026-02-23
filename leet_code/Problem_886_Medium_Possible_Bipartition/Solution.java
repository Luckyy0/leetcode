package leet_code.Problem_886_Medium_Possible_Bipartition;

import java.util.*;

/**
 * Problem 886: Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/
 */
public class Solution {

    /**
     * Determines if the graph can be split into two groups (Bipartite Graph).
     * Strategy: BFS/DFS Coloring.
     * 
     * @param n        Number of people.
     * @param dislikes Array of disliked pairs.
     * @return True if possible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán này tương đương với việc kiểm tra xem một đồ thị có phải
     *         là
     *         đồ thị hai phía (Bipartite Graph) hay không.
     *         2. Xây dựng danh sách kề từ mảng 'dislikes'.
     *         3. Sử dụng mảng 'color' để lưu màu của mỗi nút (0: chưa tô, 1: Nhóm
     *         A, -1: Nhóm B).
     *         4. Duyệt qua từng nút từ 1 đến n:
     *         - Nếu nút 'i' chưa được tô màu, bắt đầu BFS từ nó.
     *         - Tô màu cho hàng xóm của nó bằng màu đối lập (-color[u]).
     *         - Nếu gặp một hàng xóm đã được tô cùng màu với nút hiện tại, trả về
     *         false.
     *         5. Nếu duyệt hết mà không có xung đột, trả về true.
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        // Color array: 0 uncolored, 1 color A, -1 color B
        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                // Start BFS for this component
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1; // Start with color 1

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : graph.get(u)) {
                        if (color[v] == 0) {
                            color[v] = -color[u]; // Color neighbor with opposite color
                            queue.offer(v);
                        } else if (color[v] == color[u]) {
                            // Conflict: neighbor has same color
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] d1 = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println("Result: " + sol.possibleBipartition(4, d1)); // true

        int[][] d2 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println("Result: " + sol.possibleBipartition(3, d2)); // false

        int[][] d3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
        System.out.println("Result: " + sol.possibleBipartition(5, d3)); // false
    }
}
