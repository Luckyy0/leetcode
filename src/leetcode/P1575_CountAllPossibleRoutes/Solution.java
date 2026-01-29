package leetcode.P1575_CountAllPossibleRoutes;

import java.util.Arrays;

public class Solution {
    private int MOD = 1_000_000_007;
    private int[][] memo;
    private int[] locations;
    private int finish;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        this.finish = finish;
        int n = locations.length;
        this.memo = new int[n][fuel + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(start, fuel);
    }

    private int solve(int curr, int fuel) {
        if (memo[curr][fuel] != -1) {
            return memo[curr][fuel];
        }

        long ans = (curr == finish) ? 1 : 0;

        for (int next = 0; next < locations.length; next++) {
            if (next != curr) {
                int cost = Math.abs(locations[curr] - locations[next]);
                if (fuel >= cost) {
                    ans = (ans + solve(next, fuel - cost)) % MOD;
                }
            }
        }

        return memo[curr][fuel] = (int) ans;
    }
}
