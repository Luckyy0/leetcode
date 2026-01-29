# Problem Analysis: Build Array from Permutation

## Problem Description
Array `nums`.
Build `ans` where `ans[i] = nums[nums[i]]`.

## Analysis

1.  **Direct**:
    -   New array. Fill.
2.  **O(1) Space**:
    -   Store `nums[nums[i]]` in `nums[i]` using modulo arithmetic (if values fit).
    -   `nums[i] = val + (nums[val] % n) * n`.
    -   Extract: `nums[i] / n`.

## Implementation Details
-   Simple array creation $O(N)$.
