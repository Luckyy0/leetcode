# Problem Analysis: Shortest Path in a Hidden Grid

## Problem Description
Robot explores grid. `GridMaster` object: `canMove(direction)`, `move(direction)`, `isTarget()`.
Find shortest path from start to target.
If target unreachable, -1.
Grid size unknown? Usually implicit bounds. $N, M \le 500$.

## Analysis

1.  **Exploration (DFS) + Pathfinding (BFS)**:
    -   Step 1: Explore the grid using DFS to map out valid cells (0=blocked, 1=empty, 2=target).
        -   Use relative coordinates `(0,0)` as start.
        -   Map bounds can be determined or just use a large enough map (e.g., 1000x1000 initialized to unvisited).
        -   DFS: try all 4 directions. If `canMove(d)`, `move(d)`, mark visited, recurse, then `move(opposite_d)` to backtrack.
    -   Step 2: Run BFS on the mapped grid from `(0,0)` to find target.
    
2.  **Coordinates**:
    -   Offset coordinates to handle negative relative positions. Center at `500, 500`.
    
3.  **Complexity**:
    -   Exploration: $O(V+E)$ (visit each cell once).
    -   BFS: $O(V+E)$.
    -   Total size $500 \times 500$.

## Implementation Details
-   `GridMaster` interface (abstract or mock).
-   `map[1001][1001]`.
