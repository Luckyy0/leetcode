package leetcode.P1801_NumberOfOrdersInTheBacklog;

import java.util.PriorityQueue;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // Buy: Max Heap (price, amount)
        PriorityQueue<int[]> buyBacklog = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Sell: Min Heap (price, amount)
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];

            if (type == 0) { // Buy
                while (amount > 0 && !sellBacklog.isEmpty() && sellBacklog.peek()[0] <= price) {
                    int[] sell = sellBacklog.poll();
                    int trade = Math.min(amount, sell[1]);
                    amount -= trade;
                    sell[1] -= trade;
                    if (sell[1] > 0)
                        sellBacklog.offer(sell);
                }
                if (amount > 0)
                    buyBacklog.offer(new int[] { price, amount });
            } else { // Sell
                while (amount > 0 && !buyBacklog.isEmpty() && buyBacklog.peek()[0] >= price) {
                    int[] buy = buyBacklog.poll();
                    int trade = Math.min(amount, buy[1]);
                    amount -= trade;
                    buy[1] -= trade;
                    if (buy[1] > 0)
                        buyBacklog.offer(buy);
                }
                if (amount > 0)
                    sellBacklog.offer(new int[] { price, amount });
            }
        }

        long total = 0;
        int MOD = 1_000_000_007;
        for (int[] o : buyBacklog)
            total = (total + o[1]) % MOD;
        for (int[] o : sellBacklog)
            total = (total + o[1]) % MOD;

        return (int) total;
    }
}
