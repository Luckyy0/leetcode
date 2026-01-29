# Problem Analysis: Maximum of Minimum Values in All Subarrays

## Problem Description
Array `nums`.
For each length `len` (1 to n), find the maximum of (minimum of subarray of length `len`).
Return array `ans` where `ans[i]` is result for length `i+1`.

## Analysis

1.  **Monotonic Stack + Logic**:
    -   For each element `nums[i]`, find the range `[L, R]` where `nums[i]` is the minimum.
    -   Range length `len = R - L - 1`.
    -   `nums[i]` is a candidate answer for any window length $k \le len$.
    -   Result array `maxMin[len]`. Update `maxMin[len] = max(maxMin[len], nums[i])`.
    -   After filling `maxMin` using all elements:
        -   If `nums[i]` is valid min for length `L`, it is also valid for length `L-1`.
        -   So propagate max values from right to left (larger length to smaller length).
        -   `ans[k] = max(ans[k], ans[k+1])`.
    -   Algorithm:
        1.  Find `prevSmaller[i]` and `nextSmaller[i]` using Monotonic Stack.
        2.  For each `i`, `len = nextSmaller[i] - prevSmaller[i] - 1`.
        3.  `ans[len-1] = max(ans[len-1], nums[i])`.
        4.  Post-process: `for k from n-2 down to 0: ans[k] = max(ans[k], ans[k+1])`.

## Implementation Details
-   `Stack`.
-   Arrays.
