# Problem Analysis: Frequency of the Most Frequent Element

## Problem Description
Array `nums`. `k` operations. Op: inc element.
Max freq of any element.

## Analysis

1.  **Sort + Sliding Window**:
    -   Sort input.
    -   Target value is always the rightmost element in window `nums[r]`.
    -   Cost to make `nums[l...r]` equal to `nums[r]` is `nums[r] * (len) - sum(l...r)`.
    -   Maintain window sum.
    -   Condition `nums[r] * (r - l + 1) - currentSum <= k`.
    -   If valid, `maxFreq = max(maxFreq, r - l + 1)`.
    -   Else shrink left.

## Implementation Details
-   `Arrays.sort`.
-   `long` for sum to avoid overflow.
