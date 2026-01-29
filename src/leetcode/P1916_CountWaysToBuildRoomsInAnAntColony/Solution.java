package leetcode.P1916_CountWaysToBuildRoomsInAnAntColony;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int MOD = 1_000_000_007;
    List<Integer>[] adj;
    int[] subtreeSize;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            adj[prevRoom[i]].add(i);
        }

        subtreeSize = new int[n];
        dfs(0);

        long ans = factorial(n);
        for (int i = 0; i < n; i++) {
            long inv = power(subtreeSize[i], MOD - 2);
            ans = (ans * inv) % MOD;
        }

        return (int) ans;
    }

    private void dfs(int u) {
        subtreeSize[u] = 1;
        for (int v : adj[u]) {
            dfs(v);
            subtreeSize[u] += subtreeSize[v];
        }
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = (res * i) % MOD;
        return res;
    }

    private long power(long base, int exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp % 2) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
