package leetcode.P1054_DistantBarcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int b : barcodes)
            count.put(b, count.getOrDefault(b, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        pq.addAll(count.keySet());

        int n = barcodes.length;
        int[] res = new int[n];
        int idx = 0;

        while (!pq.isEmpty()) {
            int code = pq.poll();
            int freq = count.get(code);

            while (freq > 0) {
                if (idx >= n)
                    idx = 1; // Wrap to odd positions
                res[idx] = code;
                idx += 2;
                freq--;
            }
        }

        return res;
    }
}
