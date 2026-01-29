# Problem Analysis: Minimum Moves to Reach Target Score

## Problem Description
Start 1. Target `target`.
Moves: `val + 1` or `val * 2`.
Max doubles `maxDoubles`.

## Analysis

1.  **Reverse Greedy**:
    -   Work backwards from `target` to 1.
    -   If `target` even and `maxDoubles > 0`: `target /= 2`, `doubles--`, `moves++`.
    -   If `target` odd: `target--`, `moves++`.
    -   If `maxDoubles == 0`: `moves += target - 1`. `target = 1`.
    -   Loop until 1. (Or optimize logic).

## Implementation Details
-   While loop.
