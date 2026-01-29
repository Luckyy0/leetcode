# Problem Analysis: Paths in Maze That Lead to Same Room

## Problem Description
Rooms 1 to n. Corridors (edges).
Find number of cycles of length 3.
(Path `room1 -> room2 -> room3 -> room1`).
Graph is undirected? "Corridors connect two rooms". Usually undirected.
Cycle length 3 is a triangle.

## Analysis

1.  **Triangle Counting**:
    -   Iterate all edges `(u, v)`.
    -   Iterate common neighbors `w`.
    -   If `w` exists in both adjacency lists, then `u-v-w-u` is a triangle.
    -   Count will be tripled (each edge counts the triangle once). Divide by 3.
    -   Optimization:
        -   Direct edges towards `larger index`? Or sort by degree.
        -   If we treat graph as directed `u -> v` if `u < v`, then a triangle `u, v, w` with `u < v < w` corresponds to `u->v`, `v->w`, `u->w`.
        -   Iterate `u`. For each neighbor `v > u`:
            -   For each neighbor `w > v` of `v`:
                -   Check if `u` is connected to `w`.
    -   Adjacency Matrix or HashSet for O(1) check. `n` up to 1000? $O(N^3)$ matrix is ok? No $N=1000$ -> $10^9$.
    -   Constraints?
    -   Usually adjacency set check is fine. Or bitsets.
    -   With $N \le 1000$: $O(M \sqrt{M})$ or $O(M N)$.
    -   Using sorting approach:
        -   Sort adjacency lists.
        -   Or use `HashSet` intersection.
        -   Simplest: `u < v < w`.
        -   Iterate `u` from `1` to `n`.
        -   Iterate `v` in `adj[u]` where `v > u`.
        -   Iterate `w` in `adj[v]` where `w > v`.
        -   Check if `adj[u]` contains `w`. (Or `adj[w]` contains `u`).
        -   Complexity depends on denseness. $O(\sum deg(v)^2)$.
        -   Worst case dense: $N^3$.
        -   Provided constraints usually allow it or require optimized iteration (e.g. iterate edge `(u, v)` then iterate neighbors).
    -   Since graph might be sparse:
        -   Iterate edge `(u, v)` with `u < v`.
        -   Find intersection of `adj[u]` and `adj[v]`.
        -   Count elements `w > v`.

## Implementation Details
-   Adjacency matrix (boolean) to quick check? If N is small enough.
-   Else Adjacency Sets.
