package leet_code.Problem_733_Easy_Flood_Fill;

import java.util.Arrays;

public class Solution {

    /**
     * Performs flood fill starting from (sr, sc).
     * Strategy: Recursive DFS.
     * Time: O(N*M), Space: O(N*M).
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        // Critical check: avoid infinite loop if color is already the goal
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // Base cases: Out of bounds or color doesn't match
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }

        // Apply transformation
        image[r][c] = newColor;

        // Spread to 4 directions
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] result = sol.floodFill(image, 1, 1, 2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
