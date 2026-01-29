package leetcode.P1086_HighFive;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new PriorityQueue<>());
            map.get(id).add(score);
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;

        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            // PQ contains top 5 scores (or fewer if total < 5, but problem likely implies
            // >= 5 scores?)
            // Usually guaranteed to have at least 5? Leetcode P1086: "Each student has at
            // least 5 scores".
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            res[idx][0] = id;
            res[idx][1] = sum / 5;
            idx++;
        }

        return res;
    }
}
