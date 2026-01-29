# Problem Analysis: Special Array With X Elements Greater Than or Equal X

## Problem Description
You are given an array `nums` of non-negative integers. `nums` is considered special if there exists a number `x` such that there are exactly `x` numbers in `nums` that are greater than or equal to `x`.
Notice that `x` does not have to be an element in `nums`.
Return `x` if the array is special, otherwise return -1.

## Analysis

1.  **Brute Force**:
    -   Range of `x`: `0` to `nums.length`.
    -   For each candidate `x`, iterate `nums` and count elements `>= x`.
    -   If count == `x`, return `x`.
    -   If no match found after checking all `x`, return -1.

2.  **Optimization**:
    -   Sort `nums` descending.
    -   If `nums[x-1] >= x` and `(x == n || nums[x] < x)`, then `x` works?
    -   Actually, just sort ascending.
    -   Or simply: `N` is small (up to 100). Iterating 0 to 100 is instant. $N^2 = 10000$ ops.

3.  **Algorithm**:
    -   Loop `x` from 0 to `nums.length`.
    -   `cnt = 0`.
    -   Loop `num` in `nums`. If `num >= x`, `cnt++`.
    -   If `cnt == x`, return `x`.

## Implementation Details
-   Double loop.
