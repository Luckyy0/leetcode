# Problem Analysis: Detect Cycles in 2D Grid

## Problem Description
Given a 2D array of characters `grid` of size `m x n`, you need to find if there exists any cycle consisting of the same value in the grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it in one of the four directions (up, down, left, right) if it has the same value of the current cell.
Also, you cannot move to the cell that you visited in your last move (i.e. parent).

## Analysis

1.  **Graph Representation**:
    -   Each cell `(r, c)` is a node.
    -   Edges exist between adjacent cells `(r, c)` and `(nr, nc)` if `grid[r][c] == grid[nr][nc]`.
    -   The problem asks to detect a cycle in this undirected graph.

2.  **Cycle Detection (DFS/BFS)**:
    -   We can use DFS to traverse the graph.
    -   We maintain a `visited` array.
    -   For each unvisited cell, start a DFS.
    -   In DFS(current, parent):
        -   Mark `current` as visited.
        -   For each neighbor:
            -   If neighbor is the `parent`, ignore (don't go back immediately).
            -   If neighbor is already visited, we found a path back to a visited node that is not the parent => **CYCLE DETECTED**.
            -   If neighbor is not visited, recursively call DFS.

3.  **Optimization**:
    -   We need to check every component.
    -   Visited array `boolean[m][n]` is sufficient.

4.  **Complexity**:
    -   Time: $O(M \cdot N)$ because each cell is visited once.
    -   Space: $O(M \cdot N)$ for the visited array and recursion stack.

## Implementation Details
-   Iterate through all cells `(i, j)`.
-   If `!visited[i][j]`, call `dfs(i, j, -1, -1)`.
-   Directions array: `{{0,1}, {0,-1}, {1,0}, {-1,0}}`.
