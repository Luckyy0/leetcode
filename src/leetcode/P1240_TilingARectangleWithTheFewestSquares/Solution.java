package leetcode.P1240_TilingARectangleWithTheFewestSquares;

class Solution {
    int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {
        if (n == m)
            return 1;
        if (n > m)
            return tilingRectangle(m, n); // Ensure n < m for consistent logic? Or doesn't matter.

        // boolean[][] occupied = new boolean[n][m];
        // Using int[] skyline is also common but boolean grid simpler to visualize.
        dfs(0, 0, new boolean[n][m], 0);
        return ans;
    }

    private void dfs(int r, int c, boolean[][] rect, int count) {
        if (count >= ans)
            return;

        int n = rect.length;
        int m = rect[0].length;

        // Find first empty
        if (r >= n) {
            ans = count;
            return;
        }
        if (c >= m) {
            dfs(r + 1, 0, rect, count); // Move to next row
            return;
        }
        if (rect[r][c]) {
            dfs(r, c + 1, rect, count); // Move next col
            return;
        }

        // Try all sizes
        // Max size bounded by edges and occlusion
        // Max possible k is min(n-r, m-c)
        int maxK = Math.min(n - r, m - c);

        // Try largest first? Or smallest?
        // Largest first usually reduces count faster but might miss optimal packing
        // (e.g. 11x13 special case).
        // Let's try largest first for pruning benefit.
        for (int k = maxK; k >= 1; k--) {
            // Check if can place
            if (canPlace(r, c, k, rect)) {
                place(r, c, k, rect, true);
                dfs(r, c + k, rect, count + 1); // Skip c by k? No, just move to c+1 logic handles it.
                // Wait, if we place k, we cover (r,c), so moving to c+1 will see occupied.
                // To skip redundant checks, maybe not necessary with boolean check.
                // Actually if we cover column c, we can skip? No, just c+1 ok.
                place(r, c, k, rect, false);
            }
        }
    }

    private boolean canPlace(int r, int c, int k, boolean[][] rect) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[r + i][c + j])
                    return false;
            }
        }
        return true;
    }

    private void place(int r, int c, int k, boolean[][] rect, boolean val) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[r + i][c + j] = val;
            }
        }
    }
}
