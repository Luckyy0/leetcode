package leetcode.P841_KeysAndRooms;

import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int u, boolean[] visited) {
        visited[u] = true;
        for (int v : rooms.get(u)) {
            if (!visited[v]) {
                dfs(rooms, v, visited);
            }
        }
    }
}
