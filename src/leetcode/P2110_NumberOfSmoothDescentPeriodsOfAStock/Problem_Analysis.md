# Problem Analysis: Number of Smooth Descent Periods of a Stock

## Problem Description
Array `prices`.
Smooth descent period: `prices[i] == prices[i-1] - 1`.
Count all such subarrays (length >= 1).

## Analysis

1.  **DP / Consecutive Count**:
    -   If sequence `a, a-1, a-2` has length 3.
    -   Subarrays: 3 (len 1) + 2 (len 2) + 1 (len 3) = 6.
    -   Pattern: Segment of length `L` contributes `L * (L + 1) / 2`.
    -   Iterate `prices`.
    -   Track current consecutive descent length.
    -   If `prices[i] == prices[i-1] - 1`, length++.
    -   Else length = 1.
    -   Add `length` to total.
    -   (Summing length at each step is equivalent to formula).

## Implementation Details
-   `long ans`.
-   `len = 1`.
