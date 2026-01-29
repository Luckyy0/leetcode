# Problem Analysis: Minimum Degree of a Connected Trio in a Graph

## Problem Description
Undirected graph `n` nodes, `edges`.
Trio: `(u, v, w)` all connected.
Degree of trio: `deg(u) + deg(v) + deg(w) - 6`.
(Edges connected to trio nodes excluding inner trio edges).
Min degree of any trio. -1 if none.

## Analysis

1.  **Iterate Trios**:
    -   $N \le 400$. $O(N^3)$ is feasible ($6.4 \cdot 10^7$).
    -   Adjacency Matrix (boolean) for fast check.
    -   Adjacency List/Degree Array.
    -   Iterate `u` from 1 to `n`.
    -   Iterate `v` from `u+1` to `n`. Check if `adj[u][v]`.
    -   Iterate `w` from `v+1` to `n`. Check if `adj[u][w]` and `adj[v][w]`.
    -   If trio, calc degree.
    
2.  **Optimization**:
    -   Iterate edges `(u, v)` instead of all pairs.
    -   Then iterate neighbors of `u` (or `v`) to find `w`.
    -   Check if `w` connects to `v`.
    -   Time: $O(M \cdot N)$ or $O(E \cdot \text{min}(\text{deg}))$.
    -   Actually $N \le 400$ suggests $O(N^3)$ is intended.

## Implementation Details
-   `adj[401][401]`.
-   `deg[401]`.
