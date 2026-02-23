package leet_code.Problem_417_Medium_Pacific_Atlantic_Water_Flow;

import java.util.*;

public class Solution_DFSBoundary {

    /**
     * Finds cells that can flow to both Pacific and Atlantic.
     * Use multi-source DFS from boundaries inwards.
     * Time: O(MN), Space: O(MN).
     * 
     * Tìm các ô có thể chảy đến cả Thái Bình Dương và Đại Tây Dương.
     * Sử dụng DFS từ nhiều nguồn bắt đầu từ biên giới vào trong.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return res;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Horizontal boundaries: Top (Pacific) and Bottom (Atlantic)
        // Biên giới ngang: Trên (TBD) và Dưới (DTD)
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific);
            dfs(heights, m - 1, j, Integer.MIN_VALUE, atlantic);
        }

        // Vertical boundaries: Left (Pacific) and Right (Atlantic)
        // Biên giới dọc: Trái (TBD) và Phải (DTD)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atlantic);
        }

        // Intersection check
        // Kiểm tra giao điểm
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] reachable) {
        int m = heights.length;
        int n = heights[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || reachable[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        reachable[r][c] = true;

        dfs(heights, r + 1, c, heights[r][c], reachable);
        dfs(heights, r - 1, c, heights[r][c], reachable);
        dfs(heights, r, c + 1, heights[r][c], reachable);
        dfs(heights, r, c - 1, heights[r][c], reachable);
    }

    public static void main(String[] args) {
        Solution_DFSBoundary solution = new Solution_DFSBoundary();
        int[][] h1 = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        System.out.println("Result: " + solution.pacificAtlantic(h1));
    }
}
