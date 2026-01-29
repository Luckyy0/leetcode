# Problem Analysis: Find the Winner of the Circular Game

## Problem Description
Josephus problem. `n` friends, count `k`.

## Analysis

1.  **Recursive Formula**:
    -   `f(n, k) = (f(n-1, k) + k) % n`. (0-indexed).
    -   Convert to 1-indexed at the end: `ans + 1`.

## Implementation Details
-   Loop or recursion.
