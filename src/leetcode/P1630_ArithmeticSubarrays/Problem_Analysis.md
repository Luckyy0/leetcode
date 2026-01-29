# Problem Analysis: Arithmetic Subarrays

## Problem Description
You are given an integer array `nums` and two arrays `l` and `r` of size `m` representing `m` range queries.
For each query, check if the subarray `nums[l[i] ... r[i]]` can be rearranged to form an arithmetic sequence.

## Analysis

1.  **Arithmetic Sequence Property**:
    -   After sorting, the difference between adjacent elements must be constant.
    -   Wait, sorting takes $O(K \log K)$.
    -   Total complexity $M \cdot N \log N$. Given constraints $N, M \le 500$, $500 \cdot 500 \cdot 9 \approx 2 \times 10^6$ ops. Sorting is perfectly fine and simple.

2.  **O(N) Check Method**:
    -   Find `min` and `max`.
    -   `diff = (max - min) / (count - 1)`.
    -   If `(max - min)` not divisible, false.
    -   Use set/boolean array to check if all `min + k*diff` exist.
    -   This is theoretically faster but sorting is easier to implement and fast enough.

3.  **Implementation**:
    -   Loop queries.
    -   Copy subarray.
    -   Sort.
    -   Check differences.

## Implementation Details
-   `Arrays.copyOfRange`.
-   `Arrays.sort`.
