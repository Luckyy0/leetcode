package leetcode.P1405_LongestHappyString;

import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0)
            pq.offer(new int[] { a, 'a' });
        if (b > 0)
            pq.offer(new int[] { b, 'b' });
        if (c > 0)
            pq.offer(new int[] { c, 'c' });

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int len = sb.length();

            // Check last 2 chars
            if (len >= 2 && sb.charAt(len - 1) == (char) first[1] && sb.charAt(len - 2) == (char) first[1]) {
                if (pq.isEmpty())
                    break; // No alternative

                int[] second = pq.poll();
                sb.append((char) second[1]);
                second[0]--;

                if (second[0] > 0)
                    pq.offer(second);
                pq.offer(first); // Put first back
            } else {
                sb.append((char) first[1]);
                first[0]--;
                if (first[0] > 0)
                    pq.offer(first);
            }
        }

        return sb.toString();
    }
}
