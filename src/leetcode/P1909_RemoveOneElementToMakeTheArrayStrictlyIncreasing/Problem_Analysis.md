# Problem Analysis: Remove One Element to Make the Array Strictly Increasing

## Problem Description
Array `nums`.
Check if strictly increasing after removing exactly one element.

## Analysis

1.  **Scan and Check**:
    -   Find first index `i` such that `nums[i-1] >= nums[i]`.
    -   If no such index found, return true (already increasing).
    -   We must fix this "fault".
    -   Two options:
        1.  Remove `nums[i-1]`: Check if `nums` without `i-1` is sorted.
        2.  Remove `nums[i]`: Check if `nums` without `i` is sorted.
    -   We can implement a helper function `isIncreasing(arr, skipIndex)` to verify.
    -   One edge case: Multiple faults? The first check handles strict logic, but helper is safer. If `isIncreasing` returns true for either removal, then true.
    -   If we find *another* fault later, it's impossible. But we only try for the *first* fault found.

2.  **Logic Logic**:
    -   Loop `i` from 1 to `n-1`.
    -   If `nums[i-1] >= nums[i]`:
        -   Try removing `i-1` (check if rest sorted).
        -   Try removing `i` (check if rest sorted).
        -   Return `check(i-1) || check(i)`.
    -   Return `true`.

## Implementation Details
-   Helper method.
