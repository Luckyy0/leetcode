# Problem Analysis: Maximum Population Year

## Problem Description
Logs `[birth, death]`. Person alive `[birth, death - 1]`.
Find year with max population.
Years `1950` to `2050`.

## Analysis

1.  **Prefix Sum (Difference Array)**:
    -   Offset 1950. Array size 101.
    -   `pop[birth]++`.
    -   `pop[death]--`. (Since alive until `death-1`).
    -   Prefix sum to find max year.

## Implementation Details
-   `int[101]`.
