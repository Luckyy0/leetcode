# Problem Analysis: Find All K-Distant Indices in an Array

## Problem Description
`nums`, `key`, `k`.
Indices `i` such that exist `j` where `nums[j] == key` and `|i - j| <= k`.
Return sorted unique list.

## Analysis

1.  **Iteration with Range Update**:
    -   Iterate `nums`. If `nums[j] == key`:
        -   Active range `[j-k, j+k]`.
        -   We want union of these ranges.
    -   Since indices are 0 to `n-1`.
    -   Simple loop `i` from 0 to `n-1`.
    -   Keep track of `last_key_pos`. Is any key pos within distance `k`?
    -   Actually easier:
        -   Find all indices of key: `[p1, p2, ...]`.
        -   For each `i`, check if `i` is within `k` of any `p_m`.
        -   Optimization: Since `p` are sorted, check closest.
    -   OR:
        -   Iterate `j` with key. Mark intervals.
        -   Interval merging?
    -   Complexity: `N * K` or `N`.
    -   Optimal one pass:
        -   For each `i`, is there a key in `[i-k, i+k]`?
        -   Can check if `next_key_idx <= i+k` or `prev_key_idx >= i-k`.

2.  **Implementation**:
    -   Collect key indices.
    -   Loop `i`.
    -   Check against collected key indices efficiently.
    -   Actually constraints `N <= 1000`. `O(N^2)` is fine.
    -   Even simpler: Iterate `j` where `nums[j] == key`.
        -   Mark `i` from `max(0, j-k)` to `min(n-1, j+k)` as valid.
        -   Use boolean array. Collect true indices.

## Implementation Details
-   `boolean[] valid`.
-   Loop `j`. Inner loop `range`.
