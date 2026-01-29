package leetcode.P1584_MinCostToConnectAllPoints;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 1; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        int totalCost = 0;
        int edgesConnected = 0;

        // Prim's Algorithm
        while (edgesConnected < n) {
            int u = -1;
            int minVal = Integer.MAX_VALUE;

            // Find unvisited node with smallest dist
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < minVal) {
                    minVal = minDist[i];
                    u = i;
                }
            }

            visited[u] = true;
            totalCost += minVal;
            edgesConnected++;

            // Update neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0])
                            + Math.abs(points[u][1] - points[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }

        return totalCost;
    }
}
