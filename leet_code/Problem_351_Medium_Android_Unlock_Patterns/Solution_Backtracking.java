package leet_code.Problem_351_Medium_Android_Unlock_Patterns;

public class Solution_Backtracking {

    /**
     * Counts valid unlock patterns.
     * Uses Backtracking with Symmetry and Skip Matrix.
     * Time: O(N!), Space: O(N).
     * 
     * Đếm các mẫu mở khóa hợp lệ.
     * Sử dụng Quay lui với Đối xứng và Ma trận Nhảy.
     */
    public int numberOfPatterns(int m, int n) {
        // skip[i][j] stores the dot that is between i and j
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;

        boolean[] visited = new boolean[10];
        int count = 0;

        for (int i = m; i <= n; i++) {
            // Symmetry: 1, 3, 7, 9 are corners
            count += dfs(1, i - 1, visited, skip) * 4;
            // Symmetry: 2, 4, 6, 8 are edge centers
            count += dfs(2, i - 1, visited, skip) * 4;
            // 5 is the center
            count += dfs(5, i - 1, visited, skip);
        }

        return count;
    }

    private int dfs(int curr, int remaining, boolean[] visited, int[][] skip) {
        if (remaining == 0)
            return 1;

        visited[curr] = true;
        int count = 0;

        for (int next = 1; next <= 9; next++) {
            if (!visited[next]) {
                int middle = skip[curr][next];
                // Can move to next if:
                // 1. No dot in between (middle == 0)
                // 2. Intermediate dot already visited
                if (middle == 0 || visited[middle]) {
                    count += dfs(next, remaining - 1, visited, skip);
                }
            }
        }

        visited[curr] = false; // backtrack
        return count;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: m=1, n=1 -> 9
        System.out.println("Patterns (1,1): " + solution.numberOfPatterns(1, 1));

        // Test Case 2: m=1, n=2 -> 9 + 56 = 65
        System.out.println("Patterns (1,2): " + solution.numberOfPatterns(1, 2));
    }
}
