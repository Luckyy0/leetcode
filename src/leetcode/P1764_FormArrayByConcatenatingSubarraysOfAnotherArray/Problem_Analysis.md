# Problem Analysis: Form Array by Concatenating Subarrays of Another Array

## Problem Description
`groups` (list of arrays) and `nums`.
Check if `nums` can be formed by disjoint subarrays matching `groups` in order.

## Analysis

1.  **Greedy Search**:
    -   Index `idx` in `nums`.
    -   For each group `g` in `groups`:
        -   Find first occurrence of `g` in `nums` starting at or after `idx`.
        -   To match `g`, subarray `nums[k ... k+len-1]` must equal `g`.
        -   Update `idx = k + len`.
        -   If not found, return false.
    -   Return true.
    
2.  **Implementation**:
    -   Simple loop search. Or KMP if needed, but constraints usually allow simple search.

## Implementation Details
-   Loop.
