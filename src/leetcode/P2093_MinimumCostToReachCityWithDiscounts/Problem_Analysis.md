# Problem Analysis: Minimum Cost to Reach City With Discounts

## Problem Description
Graph `n` cities. `highways`: `(u, v, toll)`.
`discounts`: number of discounts available.
Discount: Reduces toll to `toll / 2` (integer division).
Min cost 0 to `n-1`. Or -1.

## Analysis

1.  **Dijkstra with State**:
    -   State `(city, discounts_used)`.
    -   `dist[city][k]` = min cost to reach city using k discounts.
    -   Transitions:
        -   To neighbor `v` with toll `cost`:
        -   Option 1: Don't use discount. `newCost = currCost + cost`. Update `dist[v][k]`.
        -   Option 2: Use discount (if `k < discounts`). `newCost = currCost + cost/2`. Update `dist[v][k+1]`.
    -   PriorityQueue `(cost, city, used)`.

## Implementation Details
-   `dist[n][discounts + 1]`.
-   PQ.
