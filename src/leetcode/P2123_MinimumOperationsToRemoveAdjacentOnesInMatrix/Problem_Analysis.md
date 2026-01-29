# Problem Analysis: Minimum Operations to Remove Adjacent Ones in Matrix

## Problem Description
Grid `grid`.
Op: Change `1` to `0`.
Goal: No two `1`s are adjacent (4-direction).
Min operations (removals).
This is Max Independent Set on Bipartite Graph / Min Vertex Cover.

## Analysis

1.  **Bipartite Matching**:
    -   Grid is Bipartite (Chessboard coloring).
    -   Nodes `(r, c)` where `grid[r][c] == 1`.
    -   Edges between adjacent 1s.
    -   We want to remove min vertices to break all edges (Vertex Cover).
    -   In Bipartite Graph: Min Vertex Cover = Max Matching.
    -   Construct Bipartite Graph: Partition into Black/White cells. E.g. `(r+c)%2 == 0` vs `1`.
    -   Edges only between Black and White.
    -   Compute Max Matching.
    -   Result is Size of Max Matching.

## Implementation Details
-   DFS/BFS for Max Matching (Hopcroft-Karp or simply Augmenting Paths).
-   Loop through Black cells. Try to match with White neighbors.
