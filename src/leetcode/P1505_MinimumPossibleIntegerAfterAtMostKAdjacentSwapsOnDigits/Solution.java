package leetcode.P1505_MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        public void update(int idx, int val) {
            idx++; // 1-based
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & (-idx);
            }
        }

        public int query(int idx) {
            idx++;
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
    }

    public String minInteger(String num, int k) {
        int n = num.length();
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < 10; i++)
            queues[i] = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queues[num.charAt(i) - '0'].offer(i);
        }

        BIT bit = new BIT(n);
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int d = 0; d <= 9; d++) {
                if (!queues[d].isEmpty()) {
                    int pos = queues[d].peek();
                    // Original pos is `pos`.
                    // Current distance = pos - (shifted amount)
                    // Shifted amount = how many elements BEFORE pos are already used.
                    int shifted = bit.query(pos - 1);
                    int cost = pos - shifted;

                    if (cost <= k) {
                        k -= cost;
                        bit.update(pos, 1); // Mark as used
                        sb.append(d);
                        queues[d].poll();
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }
}
