# Problem Analysis: Minimum Limit of Balls in a Bag

## Problem Description
`nums` (balls in bags). Max `maxOperations` splits.
Divide a bag into two.
Minimize max balls in any bag (Penalty).

## Analysis

1.  **Binary Search on Answer**:
    -   Range `left=1`, `right=max(nums)`.
    -   Check `mid`: Can we achieve max penalty `mid` with `maxOps`?
    -   For each bag `x`:
        -   If `x <= mid`, 0 ops.
        -   If `x > mid`, need splits.
        -   Splits needed = `(x - 1) / mid`. (e.g. 9 balls, limit 3. 9->3,3,3 needs 2 splits. (9-1)/3 = 2).
    -   Sum splits. If sum <= `maxOps`, true.

2.  **Complexity**:
    -   Time: $O(N \log M)$. $M = \text{max}(nums)$.
    -   Space: $O(1)$.

## Implementation Details
-   Binary search.
