package leetcode.P692_TopKFrequentWords;

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Min-Heap of size k
        // Min-Heap kích thước k
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int f1 = counts.get(w1);
            int f2 = counts.get(w2);
            if (f1 != f2)
                return f1 - f2; // Lower frequency at top
            return w2.compareTo(w1); // Lexicographically larger at top
        });

        for (String word : counts.keySet()) {
            pq.offer(word);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}
