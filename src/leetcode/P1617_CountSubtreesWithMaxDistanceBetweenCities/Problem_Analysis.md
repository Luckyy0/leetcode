# Problem Analysis: Count Subtrees With Max Distance Between Cities

## Problem Description
There are `n` cities and `n-1` roads forming a tree.
You are given `edges`.
For each `d` from 1 to `n-1`, find the number of subtrees (subsets of cities that form a connected subgraph) such that the maximum distance between any two cities in the subtree is equal to `d`.
Return an array of size `n-1` where element `i` is the count for `d=i+1`.

## Analysis

1.  **Constraints**:
    -   `n <= 15`. This is very small.
    -   We can iterate through all $2^n$ subsets of cities.

2.  **Algorithm**:
    -   Iterate `mask` from 1 to `(1 << n) - 1`.
    -   Check if the subset defined by `mask` is connected.
        -   Count set bits. If $< 2$, distance is 0 (not valid for $d \ge 1$). Skip.
        -   Pick an arbitrary node in subset. Run BFS/DFS restricted to subset to count reachable nodes. If reachable == set bits, it is connected.
    -   If connected, calculate the Diameter (max distance) of the subtree.
        -   Run BFS from arbitrary node to find farthest node `u`.
        -   Run BFS from `u` to find farthest node `v` and distance `dist`.
        -   `dist` is the diameter.
    -   Increment `result[dist - 1]`.

3.  **Preprocessing**:
    -   Precompute adjacency list `adj`.
    -   Or precompute all-pairs shortest paths `dist[i][j]` using Floyd-Warshall? Since we need distance *within* the subtree, the distance in original tree is the same as distance in subtree (edges are subset). Yes.
    -   Using Floyd-Warshall ($O(N^3)$) simplifies diameter check: Iterate all pairs in subset, max `dist[i][j]`.

4.  **Complexity**:
    -   Floyd-Warshall: $15^3 \approx 3375$.
    -   Subsets: $2^{15} \approx 32768$.
    -   Check Connectivity: $O(N)$.
    -   Check Diameter (with precomputed dists): $O(N^2)$ (pairs in subset).
    -   Total: $2^{15} \cdot N^2 \approx 7 \times 10^6$. Very safe.

## Implementation Details
-   `dist[n][n]` array.
-   `adj` for connectivity check.
