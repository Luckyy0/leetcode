# Problem Analysis: Checking Existence of Edge Length Limited Paths

## Problem Description
Graph with `n` nodes. Edge list `[u, v, dis]`.
Queries `[p, q, limit]`. Check if path exists between `p` and `q` using edges with weight strictly less than `limit`.

## Analysis

1.  **Union-Find (Offline)**:
    -   Sort edge list by weight.
    -   Sort queries by limit. Keep original indices.
    -   Iterate queries. For each query with limit `L`:
        -   Process all edges with `weight < L`.
        -   Union the nodes `u, v`.
        -   Check `find(p) == find(q)`.
        -   Store result.
    
2.  **Complexity**:
    -   Time: $O(E \log E + Q \log Q + (E+Q)\alpha(N))$.
    -   Space: $O(N + E + Q)$.

## Implementation Details
-   UnionFind class.
-   Comparator sorting.
