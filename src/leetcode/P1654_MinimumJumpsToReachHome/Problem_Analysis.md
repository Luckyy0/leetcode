# Problem Analysis: Minimum Jumps to Reach Home

## Problem Description
Bug at `0`. Home at `x`.
Jumps:
-   Forward `a`: `pos -> pos + a`.
-   Backward `b`: `pos -> pos - b`.
Constraints:
-   Cannot jump backward twice in a row.
-   Cannot jump to forbidden positions.
-   Cannot jump to negative positions.
Find minimum jumps to `x`. Return -1 if impossible.

## Analysis

1.  **Graph BFS**:
    -   State: `(position, lastJumpWasBack)`.
    -   `lastJumpWasBack`: boolean.
    -   Transitions:
        1.  `Forward`: `pos + a`. Always allowed if target valid. New state `(pos+a, false)`.
        2.  `Backward`: `pos - b`. Allowed only if `!lastJumpWasBack`. New state `(pos-b, true)`.
    -   Bounds:
        -   Lower bound: 0.
        -   Upper bound: It has been proven that if a solution exists, it can be found within `max(x, max(forbidden)) + a + b`. Let's say 6000 (since constraints are 2000).
        -   Actually, tighter bound is `6000`.
    -   Visited array: `visited[pos][state]`.

2.  **Algorithm**:
    -   Queue `(0, false)`. `dist = 0`.
    -   BFS loop.
    -   Check limit `pos <= 6000`.

3.  **Complexity**:
    -   Time: $O(\text{Bound})$.
    -   Space: $O(\text{Bound})$.

## Implementation Details
-   `Set<Integer> forbiddenSet`.
-   `visited[6001][2]`.
