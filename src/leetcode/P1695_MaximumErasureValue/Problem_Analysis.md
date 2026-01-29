# Problem Analysis: Maximum Erasure Value

## Problem Description
Max sum subarray with unique elements.

## Analysis

1.  **Sliding Window**:
    -   `set` stores elements in current window `[left, right]`.
    -   `currentSum`.
    -   Iterate `right`.
    -   While `set` contains `nums[right]`:
        -   Remove `nums[left]`. `currentSum -= nums[left]`.
        -   `set.remove(nums[left])`.
        -   `left++`.
    -   `set.add(nums[right])`. `currentSum += nums[right]`.
    -   `maxSum = max(maxSum, currentSum)`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `HashSet` or boolean array (if nums range small, $10^4$). $10^4$ range is small enough.
