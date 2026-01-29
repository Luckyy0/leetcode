package leetcode.P351_AndroidUnlockPatterns;

public class Solution {

    /**
     * Problem 351: Android Unlock Patterns
     * Approach: Bactracking (DFS)
     * 
     * Time Complexity: O(9!) upper bound
     * Space Complexity: O(1)
     */

    private int[][] skip;

    public int numberOfPatterns(int m, int n) {
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        int count = 0;
        boolean[] visited = new boolean[10];

        // Loop lengths from m to n
        for (int len = m; len <= n; len++) {
            count += dfs(1, len - 1, visited) * 4; // Corners: 1, 3, 7, 9
            count += dfs(2, len - 1, visited) * 4; // Edges: 2, 4, 6, 8
            count += dfs(5, len - 1, visited); // Center: 5
        }

        return count;
    }

    private int dfs(int curr, int remaining, boolean[] visited) {
        if (remaining == 0)
            return 1;

        visited[curr] = true;
        int result = 0;

        for (int next = 1; next <= 9; next++) {
            if (!visited[next]) {
                // If adjacent (skip=0) OR jump-over node is visited
                int cross = skip[curr][next];
                if (cross == 0 || visited[cross]) {
                    result += dfs(next, remaining - 1, visited);
                }
            }
        }

        visited[curr] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1, 1 -> 9
        runTest(solution, 1, 1, 9);

        // 1, 2 -> 65
        runTest(solution, 1, 2, 65);
    }

    private static void runTest(Solution s, int m, int n, int expected) {
        s = new Solution(); // Reset state
        int result = s.numberOfPatterns(m, n);
        System.out.println("m: " + m + ", n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
