# Problem Analysis: Swapping Nodes in a Linked List

## Problem Description
Swap values of `k`-th node from beginning and `k`-th node from end.

## Analysis

1.  **Two Pointers**:
    -   First pointer `p1` to find k-th node. Move `k-1` steps.
    -   Let `first` be `p1`.
    -   Second pointer `p2` starts at head. A temp pointer `fast` starts at `p1`.
    -   Move `fast` to end. Move `p2` with `fast`.
    -   When `fast.next` is null, `p2` is k-th from end.
    -   Swap values of `first` and `p2`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Values swap is easier than node rewiring.
