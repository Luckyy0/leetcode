package leet_code.Problem_305_Hard_Number_Of_Islands_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_UnionFind {

    /**
     * Finds number of islands after each addLand operation.
     * Uses Union-Find (DSU).
     * Time: O(K * alpha(MN)), Space: O(MN).
     * 
     * Tìm số lượng đảo sau mỗi thao tác thêm đất.
     * Sử dụng Union-Find (DSU).
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1); // -1 means water

        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = r * n + c;

            // If already land, verify state (should count stay same?)
            // Usually duplicate ops don't change anything.
            // Nếu đã là đất, kiểm tra trạng thái
            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }

            parent[idx] = idx; // Mark as land, self-parent
            count++;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int nIdx = nr * n + nc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && parent[nIdx] != -1) {
                    int root1 = find(parent, idx);
                    int root2 = find(parent, nIdx);

                    if (root1 != root2) {
                        parent[root1] = root2; // Union
                        count--;
                    }
                }
            }

            result.add(count);
        }

        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Solution_UnionFind solution = new Solution_UnionFind();

        // Test Case 1
        int[][] positions = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
        System.out.println("Counts 1: " + solution.numIslands2(3, 3, positions));

        // Test Case 2
        int[][] pos2 = { { 0, 0 } };
        System.out.println("Counts 2: " + solution.numIslands2(1, 1, pos2));
    }
}
