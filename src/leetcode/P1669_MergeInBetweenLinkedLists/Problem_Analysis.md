# Problem Analysis: Merge In Between Linked Lists

## Problem Description
You are given two linked lists: `list1` and `list2`.
Remove `list1` nodes from index `a` to `b` (inclusive).
Put `list2` in their place.
Return result.

## Analysis

1.  **Traversal**:
    -   Need `prevA`: Node at index `a - 1`.
    -   Need `afterB`: Node at index `b + 1`.
    -   Connect `prevA.next = list2`.
    -   Find last node of `list2`: `tail2`.
    -   Connect `tail2.next = afterB`.

2.  **Edge cases**:
    -   `a=0`? Problem says `0 < a <= b < n - 1`. So strictly inside.
    
3.  **Complexity**:
    -   Time: $O(N + M)$.
    -   Space: $O(1)$.

## Implementation Details
-   Pointers.
