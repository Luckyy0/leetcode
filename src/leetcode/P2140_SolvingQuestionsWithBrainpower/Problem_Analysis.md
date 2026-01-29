# Problem Analysis: Solving Questions With Brainpower

## Problem Description
Questions `[points, brainpower]`.
If solve `i`, skip next `brainpower[i]` questions (skip `i+1` to `i+brainpower[i]`).
Next available is `i + brainpower[i] + 1`.
Maximize points.

## Analysis

1.  **DP (Memoization or Tabulation)**:
    -   Iterate backwards from `n-1` to 0.
    -   `dp[i]`: Max points from `i` onwards.
    -   Options at `i`:
        1.  Solve: `points[i] + dp[i + brainpower[i] + 1]` (if valid index).
        2.  Skip: `dp[i+1]`.
    -   `dp[i] = max(solve, skip)`.

## Implementation Details
-   `long[] dp`.
-   Handle out of bounds (0).
