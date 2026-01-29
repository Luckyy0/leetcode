# Problem Analysis: Number of Spaces Cleaning Robot Cleaned

## Problem Description
Room grid `room` (0=empty, 1=blocked).
Robot at (0, 0) facing Right.
Logic:
1.  Clean current cell.
2.  Try move forward.
3.  If blocked/border, turn right (90 deg).
4.  Repeat until:
    -   Robot returns to a state (cell + direction) it has visited before?
    -   Or robot can clean no new cells?
    -   Usually simulation stops when cycle detected.
    -   Return number of unique cells cleaned.

## Analysis

1.  **Simulation with State Tracking**:
    -   State: `(r, c, dir)`. 4 directions.
    -   `visited_states[r][c][dir]`.
    -   `cleaned[r][c]`.
    -   If we reach a state `(r, c, dir)` already visited, stop. (Since deterministic).
    -   Count `cleaned` cells.
    -   Dirs: 0 (Right), 1 (Down), 2 (Left), 3 (Up).

## Implementation Details
-   2D array for room.
-   3D boolean array for visited states.
-   Loop until visited.
