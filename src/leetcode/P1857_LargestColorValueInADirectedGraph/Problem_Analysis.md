# Problem Analysis: Largest Color Value in a Directed Graph

## Problem Description
Directed graph (DAG or with cycles). Colors string.
Value of path = max frequency of any color in path.
Return largest value among all paths. -1 if cycle.

## Analysis

1.  **Topological Sort + DP**:
    -   Check for cycle using Kahn's algorithm (Topological sort). If nodes processed < N, cycle detected -> -1.
    -   DP State: `dp[u][c]` = max count of color `c` in any path ending at `u`.
    -   Colors 'a'-'z' (26).
    -   Transition: `dp[v][c] = max(dp[v][c], dp[u][c] + (color[v] == c ? 1 : 0))` for edge `u -> v`.
    -   Initialize: Indegree 0 nodes. For each start node `u`: `dp[u][color[u]] = 1`.
    -   Actually init `dp` with 0. Only update when processing.
    -   Correct logic: Process nodes in topological order.
    -   For `u` extracted from queue:
        -   For each `c` in 0..25:
            -   `val = dp[u][c]`
            -   `if (colors[u] - 'a' == c) val++`?
            -   Wait. `dp[u][c]` should already include `u`'s color?
            -   Let's define `dp[u][c]` as max count of color `c` ending at `u`.
            -   When reaching `u`, `dp[u][color[u]]` should be incremented.
            -   So, `base_dp[u][c]` derived from predecessors.
            -   `dp[u][c] = max(dp[p][c])` for all parents `p`.
            -   Then `dp[u][color[u]]++`.
            -   Optimization: Update children. For `v` where `u -> v`:
                -   `dp[v][c] = max(dp[v][c], dp[u][c])`.
            -   When `v` becomes ready (indegree 0), then increment `dp[v][color[v]]`.
            -   Wait. `dp[u]` values are final when `u` is processed.
            -   So when pushing to `v`, we push final values.
            -   When `v` is popped, we add its own color.

2.  **Complexity**:
    -   $O(26 \cdot (V + E))$.
    -   $V, E \le 10^5$. Operations $\approx 2.6 \cdot 10^6$. Very fast.

## Implementation Details
-   `int[][] dp = new int[n][26]`.
-   Adj list. Indegree array.
