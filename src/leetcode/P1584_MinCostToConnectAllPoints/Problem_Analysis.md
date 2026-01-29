# Problem Analysis: Min Cost to Connect All Points

## Problem Description
You are given an array `points` representing integer coordinates of some points on a 2D-plane, where `points[i] = [xi, yi]`.
The cost of connecting two points `[xi, yi]` and `[xj, yj]` is the manhattan distance: `|xi - xj| + |yi - yj|`.
Return the minimum cost to make all points connected.

## Analysis

1.  **Problem Type**:
    -   Minimum Spanning Tree (MST).
    -   Graph is complete (unbounded edges). Every point connects to every other point.
    -   $N \le 1000$. Edges approx $10^6$.

2.  **Algorithm Selection**:
    -   **Kruskal's**: $O(E \log E) = O(N^2 \log(N^2)) = O(N^2 \log N)$. Requires generating all edges. Feasible but memory heavy for Java object overhead if storing edge list.
    -   **Prim's**: $O(N^2)$ (dense graph implementation) or $O(E \log N)$ (heap).
    -   Dense Prim's is optimal here: $O(N^2)$ time, $O(N)$ space. No explicit edge generation required.

3.  **Prim's Algorithm**:
    -   Maintain `minDist` array (dist to MST). Initialize with $\infty$, `minDist[0] = 0`.
    -   Maintain `visited` boolean array.
    -   Loop `n` times:
        -   Find unvisited node `u` with smallest `minDist`.
        -   Mark `u` as visited. Add `minDist[u]` to `totalCost`.
        -   Update neighbors: For each unvisited `v`, `minDist[v] = min(minDist[v], dist(u, v))`.

4.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N)$.

## Implementation Details
-   Use an array for `minDist`.
-   Use manual loop to find min to avoid Heap overhead (Heap is $O(E \log V)$ which is $O(N^2 \log N)$, slightly slower than $O(N^2)$ for dense).
