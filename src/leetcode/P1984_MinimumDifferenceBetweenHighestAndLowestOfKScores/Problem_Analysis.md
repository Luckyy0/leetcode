# Problem Analysis: Minimum Difference Between Highest and Lowest of K Scores

## Problem Description
Array `nums`. Pick `k` elements.
Minimize `max(subset) - min(subset)`.

## Analysis

1.  **Sorting + Sliding Window**:
    -   Sort `nums`.
    -   Any subset of size `k` with minimum range will be a contiguous subarray in sorted array.
    -   Check `nums[i+k-1] - nums[i]` for all `i`.
    -   Return min.

## Implementation Details
-   Sort.
-   Loop.
