# Problem Analysis: Number of Orders in the Backlog

## Problem Description
Orders order type `[price, amount, orderType]`. `0` for Buy, `1` for Sell.
- Backlog consists of pending orders.
- Buy orders match with smallest Sell order if `sellPrice <= buyPrice`.
- Sell orders match with largest Buy order if `buyPrice >= sellPrice`.
- Remaining orders stay in backlog.
Total orders in backlog modulo $10^9 + 7$.

## Analysis

1.  **Priority Queues**:
    -   `buyBacklog`: Max-Heap (stores Buy orders, prioritize highest price).
    -   `sellBacklog`: Min-Heap (stores Sell orders, prioritize lowest price).
    -   Process incoming orders.
    -   If Buy order: check `sellBacklog`. While `sellBacklog.minPrice <= buyPrice`, execute trade. Reduce amounts. If sell order exhausted, remove. If buy order exhausted, stop. If buy order remains, push to `buyBacklog`.
    -   If Sell order: check `buyBacklog`. While `buyBacklog.maxPrice >= sellPrice`, execute trade.

2.  **Modulus Arithmetic**:
    -   Total amount can be large. Perform modulo at end.

## Implementation Details
-   `PriorityQueue<int[]>`. Use `long`? No wait, `amount` fits in int but total sum needs long.
-   Be careful with int overflow during sum.

