# Problem Analysis: Minimum Operations to Make the Array Alternating

## Problem Description
Make `nums` alternating: `nums[i-2] == nums[i]`.
Equivalent to: All even indices have Value A, all odd indices have Value B.
A != B.

## Analysis

1.  **Frequency Analysis**:
    -   Count freqs even indices. Find Top 2.
    -   Count freqs odd indices. Find Top 2.
    -   Try combinations.
    -   Cases: `TopEven1 != TopOdd1`, `TopEven1 == TopOdd1`.
    -   Maximize `kept_count`. Ops = Total - Kept.

## Implementation Details
-   Helper `getTop2(Map)`.
-   Logic.
