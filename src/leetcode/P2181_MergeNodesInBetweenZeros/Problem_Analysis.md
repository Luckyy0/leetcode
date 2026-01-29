# Problem Analysis: Merge Nodes in Between Zeros

## Problem Description
Linked List with nodes. Values sum between 0s.
0s mark boundaries.
Merge sums into single nodes.
Exclude 0s.

## Analysis

1.  **Iterative Traversal**:
    -   `curr` points to first node after head (head is 0).
    -   Sum while `curr.val != 0`.
    -   Create new node with sum.
    -   Skip the `0` node.
    -   Repeat.
    -   Or modify in-place:
        -   Start at `head.next`.
        -   Accumulate to `writeNode`.
        -   When 0 is hit, `writeNode` finalized. `writeNode.next` becomes next sum node.
        -   Since we must return new list (or modified), easiest is to build new list or reuse nodes. reusing is better.

## Implementation Details
-   `dummy` or reuse `head`.
-   Two pointers: `write` and `read`.
