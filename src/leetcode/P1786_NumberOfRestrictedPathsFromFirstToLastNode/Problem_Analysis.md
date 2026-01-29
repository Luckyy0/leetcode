# Problem Analysis: Number of Restricted Paths From First to Last Node

## Problem Description
Undirected weighted graph. `n` nodes.
Path restricted if `dist(node_i, n) > dist(node_{i+1}, n)`.
Count restricted paths from 1 to `n`. Modulo $10^9+7$.

## Analysis

1.  **Dijkstra + DP**:
    -   Calculate shortest distance from `n` to all other nodes. Use Dijkstra backwards from `n`.
    -   Let `D[u]` be `dist(u, n)`.
    -   We need paths $1 \to v_1 \to v_2 \dots \to n$ such that $D[1] > D[v_1] > D[v_2] \dots > D[n]$.
    -   This is counting paths on a DAG (directed acyclic graph) defined by edges $u \to v$ where $D[u] > D[v]$.
    -   Sort nodes by distance `D`. Process in increasing order of `D` (or use memoized recursion).
    -   `DP[u]` = sum of `DP[v]` for all neighbors `v` where `D[u] > D[v]`.
        -   Actually, if iterating by distance, we process from small D to large D.
        -   Start at `n` (`DP[n] = 1`).
        -   For node `u` in sorted order: `DP[u] = sum(DP[v])` for neighbors `v` with `D[v] < D[u]`.
        -   Or simply graph is transformed: edges go from `u` to `v` if `D[u] > D[v]`. We want paths from 1 to n.
        -   Wait, standard counting on DAG: `ways[u]` = num paths from `u` to `n`.
        -   `ways[u] = sum(ways[v])` where `v` is neighbor and `D[v] < D[u]`.
        -   Base case: `ways[n] = 1`.
        -   Use memoization with `dfs(1)`.

2.  **Complexity**:
    -   Dijkstra: $O(E \log N)$.
    -   DFS/DP: $O(V+E)$.
    -   Total: $O(E \log N)$.

## Implementation Details
-   `dists` array.
-   `memo` array.
-   PriorityQueue for Dijkstra.
