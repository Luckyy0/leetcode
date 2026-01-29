# Problem Analysis: Maximum XOR for Each Query

## Problem Description
Array `nums`. Sorted? Or just given.
Query `i`:
-   `nums` has size `n`.
-   Get XOR sum of current `nums`.
-   Choose `k < 2^maximumBit` such that `(xor_sum ^ k)` is maximized.
-   Answer query.
-   Remove last element of `nums`.
-   Repeat.

## Analysis

1.  **Prefix XOR**:
    -   Calculate total XOR sum.
    -   To maximize `currentXor ^ k`, `k` should have bits opposite to `currentXor` within `maximumBit` range.
    -   Let `mask = (1 << maximumBit) - 1`.
    -   `k = currentXor ^ mask`? Wait.
    -   We want `currentXor ^ k` to be max.
    -   Bits outside `maximumBit` for `k` are 0.
    -   For bits inside mask: `(currentXor ^ k)` bits should be 1.
    -   So `k = (~currentXor) & mask`.
    
2.  **Iterative**:
    -   Process from end. Current XOR is prefix XOR.
    -   Calculate `k`.
    -   Remove last element (update XOR).

## Implementation Details
-   Array output.
-   Loop.
