# Problem Analysis: Minimum Difference in Sums After Removal of Elements

## Problem Description
Array `nums` size `3n`.
Remove `n` elements. `2n` remain.
Split remaining into two parts size `n`.
Minimize `sum(first) - sum(second)`.
Since order roughly preserved (first part is left, second part is right):
-   We choose partition point `i`?
-   Actually, we remove elements such that we keep `n` elements for left part from some prefix, and `n` elements for right part from suffix.
-   Let split point indices in *original* array be significant?
-   Basically, we select `n` from first `k` elements (to minimize their sum) and `n` from remaining `3n-k` elements (to maximize their sum).
-   Pivot can range from `n` to `2n`.
-   Left Part: Choose `n` minimums from `nums[0...i]`. (Using max heap).
-   Right Part: Choose `n` maximums from `nums[i+1...3n-1]`. (Using min heap).
-   Calculate best difference.

## Analysis

1.  **Prefix/Suffix Arrays with Heaps**:
    -   `minSum[i]`: Minimum sum of `n` elements from `nums[0...i]`.
        -   Iterate `i` from `n-1` to `2n-1`.
        -   Maintain Max Heap of size `n` (smallest elements kept, largest evicted).
        -   Update sum.
    -   `maxSum[i]`: Maximum sum of `n` elements from `nums[i...3n-1]`.
        -   Iterate `i` from `2n` down to `n`. (Suffix starting at `i`).
        -   Maintain Min Heap of size `n`.
    -   Result: Min of `minSum[i] - maxSum[i+1]` for valid `i` (`n-1` to `2n-1`?).
    -   Split happens AFTER `i`.
    -   Valid range for split:
        -   Left needs at least `n`. Right needs at least `n`.
        -   Split point `k` (index of last element of left part) goes from `n-1` to `2n-1`.
        -   Left part uses subset of `0..k`. Right uses subset of `k+1..3n-1`.

## Implementation Details
-   `PriorityQueue`. `long` sums.
-   Two passes.
