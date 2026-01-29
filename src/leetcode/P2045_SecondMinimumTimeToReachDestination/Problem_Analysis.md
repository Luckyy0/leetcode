# Problem Analysis: Second Minimum Time to Reach Destination

## Problem Description
Graph `n` nodes (1 to n). `edges`. Time to traverse any edge `time`.
Traffic Lights: Green for `change` sec, Red for `change` sec. Cycle `2*change`.
Start at node 1, dest `n`.
Wait at node if Red.
Second Minimum Time is the smallest time strictly greater than Minimum Time.
Note: Can re-visit nodes/edges.

## Analysis

1.  **BFS with State**:
    -   We need 2nd minimum.
    -   Standard BFS finds minimum (shortest path in terms of edges, then time is calculated).
    -   Edges have same weight `time`.
    -   But waiting time depends on arrival time.
    -   However, `time` is positive. If we arrive via path length `L` edges, time is deterministic.
    -   Let `T(L)` be the time taken for path of length `L`.
    -   `T(L)` is monotonic with `L`.
    -   Proof: If we add an edge, we arrive later. Waiting adds time $\ge 0$.
    -   So 2nd minimum time corresponds to 2nd shortest path length OR same shortest path length with different wait time?
    -   Wait. Time depends only on `L` (number of edges).
    -   Example: `arrival = 0`. Step 1: `wait + time`.
    -   The wait at node `u` depends only on `arrival_at_u`.
    -   The `arrival_at_u` for path length `k` is fixed function `f(k)`.
        -   `arrive(0) = 0`.
        -   `arrive(k) = arrive(k-1) + wait(arrive(k-1)) + time`.
    -   Wait logic:
        -   Cycle `2*change`. Green `[0, change)`, `[2c, 3c)`.
        -   If `arr % (2*c) < c`: Green. Wait 0.
        -   If `arr % (2*c) >= c`: Red. Wait `2*c - (arr % (2*c))`.
    -   Since `time` and `change` are constant, `f(k)` is strictly increasing with `k`.
    -   Why? `f(k) - f(k-1) = wait + time`. `time >= 1`. `wait >= 0`. So `f(k) > f(k-1)`.
    -   Thus, simply finding the Strict 2nd Shortest Path Length `L2` (in terms of edges) will give the 2nd minimum time.
    -   Algorithm: Find `dist1[n]` (min edges) and `dist2[n]` (strictly larger min edges).
    -   Values strictly larger means `dist2 > dist1`.
    -   Typically `dist2 = dist1 + 1` or `dist1 + 2`.
    -   Since graph is undirected, parity matters. `dist1` and `dist1 + 1` possible?
    -   If shortest path is even length, can we have odd length path? Yes (e.g. cycle).
    -   BFS tracking 2 shortest distances for each node.
    -   `dist[u][0]` and `dist[u][1]`.
    -   Queue `(u, d)`.
    -   If `d < dist[u][0]`: update `dist[u][1] = dist[u][0]`, `dist[u][0] = d`. Push both.
    -   Else if `d < dist[u][1]` and `d != dist[u][0]`: update `dist[u][1] = d`. Push.
    -   Once we pop `n` with `dist[n][1]` found? No, keep going until reliable.
    -   Finally `L2 = dist[n][1]`. Compute `f(L2)`.

## Implementation Details
-   BFS.
-   Calculate time function.
