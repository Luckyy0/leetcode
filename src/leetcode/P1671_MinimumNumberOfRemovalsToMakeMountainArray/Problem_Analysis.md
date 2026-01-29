# Problem Analysis: Minimum Number of Removals to Make Mountain Array

## Problem Description
You are given an integer array `nums`.
A mountain array is defined as an array `arr` of length $\ge 3$ such that there exists an index `i` ($0 < i < arr.length - 1$) where $arr[0] < arr[1] < \dots < arr[i]$ and $arr[i] > arr[i+1] > \dots > arr[arr.length - 1]$.
Return the minimum number of elements to remove to make the remaining array a mountain array.

## Analysis

1.  **Longest Bitonic Subsequence**:
    -   The problem is equivalent to finding the Longest Mountain Subsequence (Bitonic Subsequence).
    -   Let `L[i]` be the length of the longest increasing subsequence ending at `i`.
    -   Let `R[i]` be the length of the longest decreasing subsequence starting at `i` (equivalent to LIS ending at `i` in reversed array).
    -   A mountain peak at `i` is valid if `L[i] >= 2` and `R[i] >= 2` (must have elements on both sides).
    -   Length of mountain with peak `i` is `L[i] + R[i] - 1`.
    -   Maximize this length.
    -   Result = `n - MaxLength`.

2.  **LIS Algorithm**:
    -   Standard DP $O(N^2)$ is sufficient given constraints ($N \le 1000$).
    -   For faster execution, use $O(N \log N)$ algorithm (binary search piles).

3.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N)$.

## Implementation Details
-   Be careful with the condition $L[i] \ge 2, R[i] \ge 2$.
