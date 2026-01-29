package leetcode.P2049_CountNodesWithTheHighestScore;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;
    long maxScore = -1;
    int count = 0;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new ArrayList[n];
        for (int i = 0; i < n; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }

        dfs(0);
        return count;
    }

    private int dfs(int u) {
        int size = 1;
        long score = 1;

        for (int v : children[u]) {
            int s = dfs(v);
            score *= s;
            size += s;
        }

        int rest = n - size;
        if (rest > 0)
            score *= rest;

        if (score > maxScore) {
            maxScore = score;
            count = 1;
        } else if (score == maxScore) {
            count++;
        }

        return size;
    }
}
