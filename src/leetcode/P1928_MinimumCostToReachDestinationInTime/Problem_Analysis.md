# Problem Analysis: Minimum Cost to Reach Destination in Time

## Problem Description
Graph `edges` (u, v, time). Nodes have `passingFees`.
Start 0, target `n-1`.
Min cost (sum of fees) such that total time <= `maxTime`.

## Analysis

1.  **Dijkstra / DP**:
    -   We want to minimize cost subject to time constraint.
    -   State: `minTime[node]`.
    -   Standard Dijkstra optimizes the primary metric. Here primary is Cost (fees). Constraint is Time.
    -   However, if we reach a node with higher cost but lower time, it might be useful.
    -   State: `minTime[u]` for a given `cost`? Costs can be large.
    -   State: `minCost[u][t]` = min cost to reach `u` in exactly `t` time.
    -   `t` up to `maxTime` (1000). `n` up to 1000.
    -   Table size $1000 \times 1000 = 10^6$. Feasible.
    -   DP / Dijkstra variant.
    -   Since edge weights (time) are positive, we can iterate time?
    -   Or just Dijkstra on `(cost, time)`.
    -   Priority Queue stores `(cost, time, u)`. Order by cost.
    -   Visited check: We only process `(u, time)` if `time < bestTimeForThisNodeSeenSoFar`.
    -   Maintain `minTime[u]`.
        -   Initially `infinity`.
        -   If we arrive at `u` with `time < minTime[u]`, update `minTime[u]` and push.
        -   This is valid because we process in increasing order of cost. The first time we reach `u` with a valid `time` it is the min cost for that `time` (or less).
        -   Wait. If we reach `u` with cost 10, time 50. Then later cost 20, time 30.
        -   The second one is useful.
        -   So `minTime[u]` stores the minimum time achieved *with any cost less than or equal to current*.
        -   Since we pop in increasing cost, any future arrival has `cost >= current`.
        -   Basically, if we extract `(c, t, u)` and `t >= minTime[u]`, discard. Because we already reached `u` with `cost <= c` and `time <= minTime[u] <= t`.
        -   This optimization reduces states significantly.

2.  **Implementation**:
    -   PQ ordered by cost.
    -   `minTime` array initialized to MAX.

## Implementation Details
-   Adjust for `passingFees` being part of cost.
-   Start: `(fee[0], 0, 0)`.
-   Edges: `(c + fee[v], t + edgeTime, v)`.
