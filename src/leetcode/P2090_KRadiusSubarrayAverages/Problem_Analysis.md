# Problem Analysis: K Radius Subarray Averages

## Problem Description
Array `nums`. Radius `k`.
For each `i`, calculate avg of subarray `[i-k ... i+k]`.
If indices out of bound, -1.
Integer division truncation.

## Analysis

1.  **Sliding Window / Prefix Sum**:
    -   Window size `2*k + 1`.
    -   Sum of window.
    -   Indices valid from `k` to `n - k - 1`.
    -   `res[i] = sum / (2k+1)`.

## Implementation Details
-   `long` sum.
-   Loop.
