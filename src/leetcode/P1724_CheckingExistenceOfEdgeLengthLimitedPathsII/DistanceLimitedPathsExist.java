package leetcode.P1724_CheckingExistenceOfEdgeLengthLimitedPathsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceLimitedPathsExist {
    private int[] parent;
    private int n;
    private List<int[]>[] mstAdj;

    // Binary lifting
    private int[][] up;
    private int[][] maxEdge;
    private int[] depth;
    private int[] component;
    private int LOG;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        this.n = n;
        // Build MST
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        mstAdj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mstAdj[i] = new ArrayList<>();

        int edgesCount = 0;
        for (int[] edge : edgeList) {
            if (union(edge[0], edge[1])) {
                mstAdj[edge[0]].add(new int[] { edge[1], edge[2] });
                mstAdj[edge[1]].add(new int[] { edge[0], edge[2] });
                edgesCount++;
            }
        }

        // Prepare LCA
        LOG = 20;
        up = new int[n][LOG];
        maxEdge = new int[n][LOG];
        depth = new int[n];
        component = new int[n];
        Arrays.fill(component, -1);

        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                dfs(i, i, 0, 0, compId++);
            }
        }
    }

    // Find set
    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    // Union set
    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }

    private void dfs(int u, int p, int d, int w, int cId) {
        component[u] = cId;
        depth[u] = d;
        up[u][0] = p;
        maxEdge[u][0] = w;

        for (int i = 1; i < LOG; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
            maxEdge[u][i] = Math.max(maxEdge[u][i - 1], maxEdge[up[u][i - 1]][i - 1]);
        }

        for (int[] edge : mstAdj[u]) {
            int v = edge[0];
            int weight = edge[1];
            if (v != p) {
                dfs(v, u, d + 1, weight, cId);
            }
        }
    }

    public boolean query(int p, int q, int limit) {
        if (component[p] != component[q])
            return false;
        return getMaxPath(p, q) < limit;
    }

    private int getMaxPath(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int maxW = 0;
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                maxW = Math.max(maxW, maxEdge[u][i]);
                u = up[u][i];
            }
        }

        if (u == v)
            return maxW;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                maxW = Math.max(maxW, maxEdge[u][i]);
                maxW = Math.max(maxW, maxEdge[v][i]);
                u = up[u][i];
                v = up[v][i];
            }
        }

        maxW = Math.max(maxW, maxEdge[u][0]);
        maxW = Math.max(maxW, maxEdge[v][0]);
        return maxW;
    }
}
