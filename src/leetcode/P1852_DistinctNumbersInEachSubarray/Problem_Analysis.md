# Problem Analysis: Distinct Numbers in Each Subarray

## Problem Description
Array `nums`. `k`.
Count distinct numbers in every subarray of size `k`.

## Analysis

1.  **Sliding Window**:
    -   Maintain `k` size window.
    -   Use `HashMap` (or Array if range small) to count frequencies.
    -   When `freq` becomes 0, remove from count. When new element comes, if `freq` becomes 1, add to count.
    -   Input range: `nums` up to $10^5$. Use Map or Array.
    -   Array is faster if constraint allows ($10^5$).
    -   Wait, constraints: `nums[i] <= 10^5`. Array is best.

2.  **Implementation**:
    -   Init first `k` elements.
    -   Slide window.

## Implementation Details
-   `int[] count = new int[100001]`.
-   `distinct` counter.
