# Problem Analysis: Sum of Absolute Differences in a Sorted Array

## Problem Description
Sorted array `nums`. For each `i`, calc `sum(|nums[i] - nums[j]|)` for all `j`.

## Analysis

1.  **Math**:
    -   `ans[i] = (i * nums[i] - leftSum) + (rightSum - (n - 1 - i) * nums[i])`.
    -   `leftSum`: sum of `nums[0...i-1]`.
    -   `rightSum`: sum of `nums[i+1...n-1]`.
    -   Total Sum `S` is constant.
    -   `rightSum = S - leftSum - nums[i]`.
    -   `leftSum` can be updated iteratively.

2.  **Algorithm**:
    -   Calc `totalSum`.
    -   Iterate `i`:
        -   Compute `rightSum`.
        -   Compute `ans`.
        -   Update `leftSum`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$ (ignoring result array).

## Implementation Details
-   `leftSum` starts 0.
