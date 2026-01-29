# Problem Analysis: Recover the Original Array

## Problem Description
Array `nums` ($2n$). Created from `original` ($n$) by:
`lower[i] = original[i] - k`.
`higher[i] = original[i] + k`.
`nums` is shuffle of `lower` and `higher`.
Find `original`. `k > 0`. `nums` length up to 2000.

## Analysis

1.  **Sort and Search k**:
    -   Sort `nums`.
    -   `nums[0]` MUST be `lower[0]`.
    -   One of `nums[1]`, `nums[2]`, ... `nums[n]` MUST be `higher[0]`.
    -   This defines `2k = higher[0] - lower[0]`. So `2k = nums[i] - nums[0]`.
    -   `k` candidate: `(nums[i] - nums[0]) / 2`. (Must be even diff).
    -   For a candidate `k`:
        -   Try to reconstruct `original`.
        -   Use frequency map or two pointers/boolean visited array.
        -   Use boolean `visited`. `nums[0]` matches `nums[0] + 2k`.
        -   Iterate through `nums`. If unvisited:
            -   This must be a `lower`. Target `higher` is `val + 2k`.
            -   Search for `val + 2k` in `nums` (unvisited).
            -   If found, pair them, record `val + k` as original.
            -   If not found, `k` is invalid.
    -   Since `n` up to 1000. Candidates for `k` up to `n`. Verification $O(N)$. Total $O(N^2)$.
    -   $N=1000 \implies N^2 = 10^6$. Fast.

## Implementation Details
-   Sort.
-   Loop `i` from 1 to `n` (not 2n, since `higher[0]` must be in first half? No. `nums` sorted logic. `lower` elements are generally smaller. But range can overlap).
    -   Actually `nums[0]` is definitely `lower[0]`. `higher[0]` corresponds to it.
    -   Usually `higher[0]` is relatively small, but could be large.
    -   But we can just try all `nums[i]` where `(nums[i] - nums[0]) > 0` and even?
    -   Wait. Since `2k = nums[i] - nums[0]`, `k` is determined.
    -   Try candidates. Early exit on first valid.
-   Verification creates array.
