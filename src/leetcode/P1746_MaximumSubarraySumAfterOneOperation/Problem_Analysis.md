# Problem Analysis: Maximum Subarray Sum After One Operation

## Problem Description
Array `nums`. One operation: replace `nums[i]` with `nums[i]^2`.
Max subarray sum.

## Analysis

1.  **DP**:
    -   `dp[i][0]` = max subarray sum ending at `i` (no swap).
    -   `dp[i][1]` = max subarray sum ending at `i` (with 1 swap).
    -   `dp[i][0] = max(nums[i], nums[i] + dp[i-1][0])`.
    -   `dp[i][1] = max(nums[i]^2, nums[i]^2 + dp[i-1][0], nums[i] + dp[i-1][1])`.
        -   Swap at current: `nums[i]^2 + max(0, prev_no_swap)`.
        -   Swap already done: `nums[i] + prev_with_swap`.
    -   Result is `max(dp[i][1])`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$ (variables).

## Implementation Details
-   Be careful with initialization.
