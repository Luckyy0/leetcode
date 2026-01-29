# Problem Analysis: Maximum Score of a Good Subarray

## Problem Description
`nums`. `k`.
Subarray `(i, j)` where `i <= k <= j`.
Score `min(nums[i...j]) * (j - i + 1)`.
Maximize score.

## Analysis

1.  **Two Pointers (Expansion)**:
    -   Start `l = k, r = k`. MinVal = `nums[k]`. Score = `nums[k]`.
    -   Expand `l` left and `r` right efficiently.
    -   Always expand the side with the larger element to keep `min` as high as possible.
    -   If `nums[l-1] > nums[r+1]`, expand left. Else right.
    -   Update min. Calculate score.
    -   Continue until bounds reached.

2.  **Greedy Logic**:
    -   The bottleneck is the minimum element. To maximize `min * length`, if we decrease `min`, we want to increase `length` as much as possible.
    -   Actually, if current min is `m`, we can expand left/right as long as elements are `>= m`. If blocked by smaller elements on both sides, we MUST degrade `m`.
    -   Which side to pick? The one with larger element. Why? Because that element will be the new `min` (or help maintain a higher min in future?).
    -   Actually simple: if we pick `l-1`, new min is `min(m, nums[l-1])`. If `r+1`, `min(m, nums[r+1])`.
    -   We want new min to be max possible. `max(min(m, nums[l-1]), min(m, nums[r+1]))`.
    -   So pick side with larger neighbor.

## Implementation Details
-   While loop.
