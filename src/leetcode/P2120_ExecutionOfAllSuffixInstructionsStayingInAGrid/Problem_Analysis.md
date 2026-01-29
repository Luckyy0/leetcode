# Problem Analysis: Execution of All Suffix Instructions Staying in a Grid

## Problem Description
Grid `n x n`. Start `startPos`. String `s` instructions (L, R, U, D).
For each suffix of `s`, how many instructions can be executed before staying?
Return array answer.

## Analysis

1.  **Simulation for Each Suffix**:
    -   `m` instructions.
    -   For `i` from 0 to `m-1`:
        -   Simulate execution starting from `startPos`.
        -   Run loop executed until out of bounds or end of string.
        -   Count steps.
    -   Complexity: $O(m^2)$. $m \le 500$. $500^2 = 250,000$. Feasible.

## Implementation Details
-   Outer loop `i`.
-   Inner loop `j`.
-   Check bounds.
