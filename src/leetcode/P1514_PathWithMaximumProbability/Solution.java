package leetcode.P1514_PathWithMaximumProbability;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class Pair {
        int node;
        double prob;

        public Pair(int n, double p) {
            node = n;
            prob = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            double p = curr.prob;

            if (u == end)
                return p;
            if (p < maxProb[u])
                continue;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                double edgeP = neighbor.prob;
                if (maxProb[u] * edgeP > maxProb[v]) {
                    maxProb[v] = maxProb[u] * edgeP;
                    pq.offer(new Pair(v, maxProb[v]));
                }
            }
        }

        return 0.0;
    }
}
