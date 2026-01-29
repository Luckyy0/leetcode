package leetcode.P767_ReorganizeString;

import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray())
            counts[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                if (counts[i] > (s.length() + 1) / 2)
                    return "";
                pq.add(new int[] { i, counts[i] });
            }
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char) (first[0] + 'a'));
            sb.append((char) (second[0] + 'a'));

            if (--first[1] > 0)
                pq.add(first);
            if (--second[1] > 0)
                pq.add(second);
        }

        if (!pq.isEmpty()) {
            sb.append((char) (pq.poll()[0] + 'a'));
        }

        return sb.toString();
    }
}
