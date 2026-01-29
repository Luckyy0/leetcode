# Problem Analysis: Number of Ways to Arrive at Destination

## Problem Description
Graph `n` nodes, `roads` (u, v, time).
Min time from 0 to n-1.
Count number of ways to travel with min time. MOD $10^9 + 7$.

## Analysis

1.  **Dijkstra + DP**:
    -   Standard Dijkstra to find min distances.
    -   Simultaneously maintain `count[u]` (number of ways to reach `u` with `dist[u]`).
    -   State updates:
        -   If `newDist < dist[v]`: `dist[v] = newDist`, `count[v] = count[u]`, push to PQ.
        -   If `newDist == dist[v]`: `count[v] = (count[v] + count[u]) % MOD`.
    -   Use `long` for distances.

## Implementation Details
-   Priority Queue usually stores `(dist, u)`.
-   Mod arithmetic.
