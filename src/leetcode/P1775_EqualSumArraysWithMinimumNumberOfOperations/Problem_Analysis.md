# Problem Analysis: Equal Sum Arrays With Minimum Number of Operations

## Problem Description
Two arrays `nums1`, `nums2`. Values 1-6.
Op: change any number to 1-6.
Min ops to make `sum1 == sum2`.

## Analysis

1.  **Greedy**:
    -   Calculate `sum1`, `sum2`. Assume `sum1 < sum2` (swap if needed). `Diff = sum2 - sum1`.
    -   We want to increase `nums1` and decrease `nums2`.
    -   Available gains in `nums1`: `6 - val`.
    -   Available reductions in `nums2`: `val - 1`.
    -   Collect all potential changes into a frequency array (gains 1 to 5).
    -   Iterate gains from 5 down to 1.
    -   Use max gains first to reduce `Diff`.
    -   Count ops.

2.  **Complexity**:
    -   Time: $O(N + M)$.
    -   Space: $O(1)$ (freq array size 6).

## Implementation Details
-   `diff`.
-   `count` array for gains.
