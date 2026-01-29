# Problem Analysis: Maximum Element After Decreasing and Rearranging

## Problem Description
Array `arr`.
Rearrange elements.
Can decrease value to any smaller positive integer.
Constraints:
- `arr[0] = 1`.
- `abs(arr[i] - arr[i-1]) <= 1`.
Maximize `arr[n-1]`.

## Analysis

1.  **Sort and Greedy**:
    -   Sort array.
    -   Set `arr[0] = 1`.
    -   Iterate `i` from 1. `arr[i]` can be at most `arr[i-1] + 1` (constraint).
    -   Since we want to maximize, set `arr[i] = min(arr[i], arr[i-1] + 1)`.
    -   (Since we can decrease `arr[i]` freely, if `arr[i]` was large, we clamp it to `arr[i-1]+1`. If it was small, it stays small).
    -   Actually, we can reduce values. Can we increase? No.
    -   So new `arr[i]` must be `<= original_sorted_arr[i]`.
    -   Max possible `arr[i]` is `min(sorted[i], prev + 1)`.

## Implementation Details
-   Sort.
-   Loop.
