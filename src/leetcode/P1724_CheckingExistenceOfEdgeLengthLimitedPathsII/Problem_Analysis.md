# Problem Analysis: Checking Existence of Edge Length Limited Paths II

## Problem Description
Online queries `(p, q, limit)`.
Graph with edge weights.
Check if path exists with weights < `limit`.

## Analysis

1.  **MST Property**:
    -   The path in the Maximum Spanning Tree (MST)? No, Minimum Spanning Tree.
    -   The path between `p` and `q` in the MST minimizes the maximum edge weight on the path.
    -   Let `max_weight(MST_path(p, q))` be `W`.
    -   If `W < limit`, answer True. Else False.
    
2.  **Implementation**:
    -   Precompute MST using Kruskal's or Prim's.
    -   Build adjacency of MST.
    -   Precompute LCA and `maxEdge` on path to ancestor using Binary Lifting.
    -   `up[node][i]` = $2^i$-th ancestor.
    -   `maxW[node][i]` = max edge weight on path to $2^i$-th ancestor.
    
3.  **Disconnected Graph**:
    -   MST might be forest.
    -   If `find(p) != find(q)`, False.
    
4.  **Complexity**:
    -   Build MST: $O(E \log E)$.
    -   Preprocessing: $O(N \log N)$.
    -   Query: $O(\log N)$.

## Implementation Details
-   `DistanceLimitedPathsExist` class.
