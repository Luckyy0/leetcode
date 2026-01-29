package leetcode.P305_NumberOfIslandsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 305: Number of Islands II
     * Approach: Union-Find (DSU)
     * 
     * Time Complexity: O(K * alpha(MN))
     * Space Complexity: O(MN)
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        // Use 1D array for DSU parent: index = r * n + c
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1); // -1 indicates water

        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = r * n + c;

            // If already land, just add current count and continue
            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }

            // Make it land
            parent[idx] = idx;
            count++;

            // Union with neighbors
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                int nIdx = nr * n + nc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && parent[nIdx] != -1) {
                    int p1 = find(parent, idx);
                    int p2 = find(parent, nIdx);

                    if (p1 != p2) {
                        parent[p1] = p2;
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
        Solution solution = new Solution();

        // 3, 3, [[0,0],[0,1],[1,2],[2,1]] -> [1,1,2,3]
        int[][] pos = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
        runTest(solution, 3, 3, pos, Arrays.asList(1, 1, 2, 3));
    }

    private static void runTest(Solution s, int m, int n, int[][] positions, List<Integer> expected) {
        List<Integer> result = s.numIslands2(m, n, positions);
        System.out.println("Positions: " + Arrays.deepToString(positions));
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
