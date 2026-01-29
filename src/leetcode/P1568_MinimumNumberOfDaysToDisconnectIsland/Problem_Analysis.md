# Problem Analysis: Minimum Number of Days to Disconnect Island

## Problem Description
You are given an `m x n` binary grid `grid` where `1` represents land and `0` represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of `1`s.
The grid is said to be connected if we have exactly one island, otherwise is disconnected.
In one day, we are allowed to change any single land cell `(1)` into a water cell `(0)`.
Return the minimum number of days to disconnect the grid.

## Analysis

1.  **Possible Answers**:
    -   The answer is always 0, 1, or 2.
    -   **0**: If the grid is already disconnected (0 islands or >= 2 islands).
    -   **1**: If removing a single critical land cell (articulation point) disconnects the grid (increases count of components > 1 or reduces to 0).
    -   **2**: It is known that for any grid (polyomino) that isn't trivial, we can detach a corner or a protuberance using at most 2 moves. (Though for very small islands, e.g., 2 cells, 2 moves might empty it completely, which counts as disconnected - 0 islands).

2.  **Algorithm**:
    -   Step 1: Check if initially disconnected. `if (countIslands() != 1) return 0`.
    -   Step 2: Try removing each land cell one by one.
        -   Set `grid[i][j] = 0`.
        -   `if (countIslands() != 1) return 1`.
        -   Backtrack: `grid[i][j] = 1`.
    -   Step 3: If no single removal works, return 2.

3.  **Corner Cases**:
    -   Grid with all 0s -> 0 islands -> return 0. (Correct).
    -   Grid with 1 cell -> 1 island. Remove 1 -> 0 islands -> disconnected. Ans should be 1. (Handled by step 2).
    -   Grid with 2 cells connected -> 1 island. Remove 1 -> 1 island left. But wait, removing one leaves 1 island. Removing 2 works. So logic says 2. Is this correct?
        -   Example `[[1,1]]`. Disconnected? No. Remove (0,0) -> `[[0,1]]` (1 island). Remove (0,1) -> `[[1,0]]` (1 island). Step 2 fails. Return 2. Correct.
    -   Grid with 3 cells `[[1,1], [1,0]]`?
    -   Actually, for `[[1,1]]`, removing *one* cell leaves `[[0,1]]` which is 1 island. We need 1 island NOT equal to 1.
    -   Definition: "Disconnected" means number of islands != 1.
    -   So for `[[1,1]]`, removing one gives `[[0,1]]` -> 1 island -> Still connected. So return 2. Correct.
    -   Wait, what if `[[1,1]]` -> Is 2 days correct? Yes. Removing both implies removing 2.
    -   Wait, what if `[[1,1,1]]`? Remove middle -> `1, 0, 1` -> 2 islands -> Disconnected. Ans 1.

4.  **Complexity**:
    -   Grid size $M, N \le 30$.
    -   Counting islands is $O(MN)$.
    -   Outer loop (try removing each) is $MN$.
    -   Total $O((MN)^2) \approx 900^2 \approx 8 \times 10^5$. Feasible.

## Implementation Details
-   `countIslands()` helper using DFS/BFS.
