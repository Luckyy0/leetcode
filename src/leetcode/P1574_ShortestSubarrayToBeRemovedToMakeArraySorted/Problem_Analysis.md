# Problem Analysis: Shortest Subarray to be Removed to Make Array Sorted

## Problem Description
Given an integer array `arr`, remove a subarray (can be empty) from `arr` such that the remaining elements in `arr` are non-decreasing.
Return the length of the shortest subarray to remove.

## Analysis

1.  **Goal**:
    -   Retain a sorted prefix `arr[0...i]` and a sorted suffix `arr[j...n-1]` such that `arr[i] <= arr[j]`.
    -   Minimize `(j - i - 1)`.
    -   Special cases:
        -   Remove only suffix (keep prefix). `j = n`.
        -   Remove only prefix (keep suffix). `i = -1`.

2.  **Steps**:
    -   Find the longest non-decreasing prefix ending at `left`. (`arr[0] <= ... <= arr[left]`).
    -   Find the longest non-decreasing suffix starting at `right`. (`arr[right] <= ... <= arr[n-1]`).
    -   If `left >= right`, array is already sorted. Return 0.
    -   Initialize `ans = min(n - 1 - left, right)`. (Removing all after left, or all before right).
    -   **Merge Logic**:
        -   Use two pointers. `i` in `0...left`, `j` in `right...n-1`.
        -   For each `i`, find the smallest `j` such that `arr[j] >= arr[i]`.
        -   Update `ans = min(ans, j - i - 1)`.

3.  **Two Pointers Details**:
    -   Loop `i` from 0 to `left`.
    -   While `j < n` and `arr[j] < arr[i]`, increment `j`.
    -   `ans = min(ans, j - i - 1)`.
    -   Note: `j` only increases.

4.  **Complexity**:
    -   Time: $O(N)$ - scanning prefix, suffix, and merging.
    -   Space: $O(1)$.

## Implementation Details
-   Careful with bounds.
