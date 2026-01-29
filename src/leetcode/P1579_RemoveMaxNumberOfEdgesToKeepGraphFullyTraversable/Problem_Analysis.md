# Problem Analysis: Remove Max Number of Edges to Keep Graph Fully Traversable

## Problem Description
Type 1 edges: Traversable by Alice.
Type 2 edges: Traversable by Bob.
Type 3 edges: Traversable by both.
Return maximum number of edges to remove such that both Alice and Bob can traverse the entire graph (graph fully connected for both). Return -1 if impossible.

## Analysis

1.  **Greedy Strategy**:
    -   Type 3 edges are the most valuable because one edge counts for both Alice and Bob.
    -   We should prioritize checking/adding Type 3 edges first. If a Type 3 edge connects two previously unconnected components (for both), it's useful.
    -   After processing all Type 3 edges, we process Type 1 edges for Alice (to connect her graph) and Type 2 edges for Bob.
    -   Any edge that doesn't merge components (i.e., vertices already connected) is redundant and can be removed.

2.  **Data Structure**:
    -   Union-Find (DSU).
    -   We need two DSU instances: `dsuAlice` and `dsuBob`. 
    -   However, they start synchronized. When adding Type 3, we add to both.
    -   Actually, we process Type 3. If `union(u, v)` returns true in `dsuAlice` (or generic `dsu`), then this edge is useful. We add it to both `dsuAlice` and `dsuBob`. This maintains that `dsuAlice` and `dsuBob` share the Type 3 structures.
    -   Then we process Type 1 on `dsuAlice`.
    -   Then we process Type 2 on `dsuBob`.

3.  **Algorithm**:
    -   `edgesUsed = 0`.
    -   Initialize `dsuAlice` and `dsuBob`.
    -   Iterate Type 3 edges:
        -   If `dsuAlice.union(u, v)` (which implies `dsuBob` should also union as they are identical so far):
            -   `dsuBob.union(u, v)` (redundant check but necessary to update state).
            -   `edgesUsed++`.
    -   Iterate Type 1 edges:
        -   If `dsuAlice.union(u, v)`: `edgesUsed++`.
    -   Iterate Type 2 edges:
        -   If `dsuBob.union(u, v)`: `edgesUsed++`.
    -   Check if `dsuAlice` is fully connected (components == 1).
    -   Check if `dsuBob` is fully connected.
    -   If both connected, `return totalEdges - edgesUsed`. Else -1.

4.  **Complexity**:
    -   Time: $O(E \alpha(V))$.
    -   Space: $O(V)$.

## Implementation Details
-   Implement generic DSU class.
