# Problem Analysis: Maximum Number of Accepted Invitations

## Problem Description
`grid[m][n]`. `grid[i][j] = 1` if boy `i` invites girl `j`.
Bipartite matching. Max matching size.

## Analysis

1.  **Max Bipartite Matching**:
    -   Standard algorithm using DFS/BFS (Augmenting Paths).
    -   Or Max Flow (Dinic).
    -   Since $M, N \le 200$ is small, simple DFS matching is sufficient.
    -   `match` array for girls (who matches whom).
    -   `vis` array for each DFS attempt.
    -   Iterate each boy, try to find augmenting path.

2.  **Complexity**:
    -   $O(V \cdot E)$. Here $M \cdot (M \cdot N)$.
    -   $200^3 = 8 \cdot 10^6$. Fast enough.

## Implementation Details
-   `match` array size `n`.
-   DFS function.
