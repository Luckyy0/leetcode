package leet_code.Problem_547_Medium_Number_of_Provinces;

public class Solution_DFS {

    /**
     * Finds the number of provinces.
     * Strategy: DFS to find connected components.
     * Time: O(N^2), Space: O(N).
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        Solution_DFS sol = new Solution_DFS();
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println("Provinces: " + sol.findCircleNum(isConnected)); // Output: 2
    }
}
