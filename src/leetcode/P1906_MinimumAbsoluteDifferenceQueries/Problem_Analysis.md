# Problem Analysis: Minimum Absolute Difference Queries

## Problem Description
Array `nums` ($1 \le nums[i] \le 100$). Array `queries` (`l`, `r`).
For each query, find the minimum absolute difference between any two **distinct** elements in the subarray `nums[l...r]`. If all elements are same or empty, return -1.

## Analysis

1.  **Prefix Sum of Frequencies**:
    -   Since the value range is small (1 to 100), we can track the frequency of each number in the subarray efficiently.
    -   Create a 2D prefix sum array `freq[i][v]` which stores the count of value `v` in `nums[0...i-1]`.
    -   Size: $(N+1) \times 101$.
    -   For a query $(l, r)$:
        -   Count of value `v` in range is `freq[r+1][v] - freq[l][v]`.
    -   Iterate $v$ from 1 to 100. If count > 0, the value `v` exists in the subarray.
    -   Collect all existing values.
    -   Iterate the sorted existing values and find the minimum difference between adjacent values.
    -   If fewer than 2 distinct values exist, return -1.

2.  **Complexity**:
    -   Preprocessing: $O(N \times C)$ where $C=100$.
    -   Per Query: $O(C)$.
    -   Total: $O((N+Q) \times C)$.
    -   Constraints: $N, Q \le 10^5$, $C=100$. Calculations $\approx 10^7$, feasible.

## Implementation Details
-   `int[][] pre = new int[n + 1][101]`.
-   Loop queries.
