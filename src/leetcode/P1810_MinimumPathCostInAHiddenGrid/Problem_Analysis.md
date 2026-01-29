# Problem Analysis: Minimum Path Cost in a Hidden Grid

## Problem Description
Robot in grid. `GridMaster`. `move` has cost.
Find min cost to target.
If unreachable, -1.

## Analysis

1.  **Exploration then Search**:
    -   Since costs might vary, BFS on grid (Dijkstra) is needed *after* exploring/building the grid.
    -   Wait, we don't know costs until we query `moveCost`? Usually `move` return boolean or cost?
    -   Interface: `int queryCost(char direction)`? Or `move` returns cost?
    -   Ah, problem usually provides costs or `master.move` returns cost.
    -   Assuming `master.move` returns cost (or we have a `query`?).
    -   Assume `GridMaster` has `move(char)` returning boolean, and costs are fixed?
    -   Checking typical "Hidden Grid" cost problem (Hard): usually costs are provided via `queryCost` or `move` costs.
    -   Let's assume there is a way to get cost.
    -   Or maybe `master` provides cost of moving in a direction without moving?
    -   Standard: `master.move` returns cost? No, `move` is void usually.
    -   Likely `query(dir)` returns cost.
    -   Strategy:
        -   DFS to map out the grid and costs.
        -   Store graph (adj list).
        -   Dijkstra on the graph.
    -   Coordinates offset (start 0,0 -> mapped to 100,100).

2.  **Mapping**:
    -   Before moving `dir` from `(r, c)`, query cost. Store it.
    -   Then move. If successful, continue DFS. Backtrack.

## Implementation Details
-   `GridMaster` interface assumptions.
-   Be careful with backtracking: `move` back costs something too? Or cost symmetric? Usually symmetric. Map it once.
