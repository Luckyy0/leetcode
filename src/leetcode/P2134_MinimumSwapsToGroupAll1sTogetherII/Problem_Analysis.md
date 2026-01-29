# Problem Analysis: Minimum Swaps to Group All 1's Together II

## Problem Description
Binary data `nums` (Circular).
Group all 1s.

## Analysis

1.  **Sliding Window on Circular Array**:
    -   Count total 1s: `ones`.
    -   Window size `ones`.
    -   Find window with max number of 1s inside.
    -   Swaps needed = `ones - max_ones_in_window`.
    -   Circular: append array to itself or modulo index.

## Implementation Details
-   `ones` count.
-   Loop `2*n`.
-   Maintain window sum.
-   If `i >= ones`, remove `i-ones`.
