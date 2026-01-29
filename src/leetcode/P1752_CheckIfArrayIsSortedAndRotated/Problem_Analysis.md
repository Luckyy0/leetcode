# Problem Analysis: Check if Array Is Sorted and Rotated

## Problem Description
Array `nums`. Return true if it was sorted then rotated some number of positions.

## Analysis

1.  **Count Descending**:
    -   Sorted rotated array has at most one "drop" (A[i] > A[i+1]).
    -   If one drop, then must also check A[n-1] <= A[0].
    -   If zero drops, it's sorted (rotation 0), valid.
    -   If > 1 drops, invalid.

## Implementation Details
-   Loop modulo $N$. Count drops.
