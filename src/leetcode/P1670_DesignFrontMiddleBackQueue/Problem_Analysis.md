# Problem Analysis: Design Front Middle Back Queue

## Problem Description
Design a queue that supports push and pop operations from front, middle, and back.
-   `pushFront`, `pushMiddle`, `pushBack`
-   `popFront`, `popMiddle`, `popBack`
Middle index:
-   If even size, middle is `size / 2` (right-biased for push? No, check problem detail).
-   "Middle" for push: if 2 elements, insert between them.
-   Example: `[1, 2]`. PushMiddle 3 -> `[1, 3, 2]`.
-   PopMiddle: if `[1, 2, 3]`, pop 2. If `[1, 2]`, pop 1 (left-biased).

## Analysis

1.  **Dual Deque**:
    -   `left` Deque, `right` Deque.
    -   Maintain invariants: `size(left) == size(right)` or `size(left) == size(right) - 1`.
    -   i.e. Right always equal or 1 larger than Left.
    
2.  **Operations**:
    -   `pushFront`: `left.addFirst`. Rebalance: if `left > right`, move leftLast to rightFirst.
    -   `pushBack`: `right.addLast`. Rebalance: if `right > left + 1`, move rightFirst to leftLast.
    -   `pushMiddle`:
        -   If `left.size == right.size`: `right.addFirst` (middle goes to Right).
        -   If `left.size < right.size`: `left.addLast`.
    -   `popFront`: `left.pollFirst`. Rebalance (pull from right). If left empty and right not, pull from right.
    -   `popBack`: `right.pollLast`. Rebalance.
    -   `popMiddle`:
        -   If `left.size == right.size`: Pop `left.pollLast` (left-biased).
        -   If `left.size < right.size`: Pop `right.pollFirst`. (Wait, verify definition).
        -   Def: `[1, 2]` popMiddle returns 1. `left=[1], right=[2]`. If size=2, pop index 1 (0-based)? No, "2 elements -> index 0 and 1. Middle is index 0". So `left.pollLast`.
        -   Def: `[1, 2, 3]` popMiddle returns 2. `left=[1], right=[2, 3]`. Right has middle. `right.pollFirst`.
        -   Correct.

3.  **Complexity**:
    -   Amortized $O(1)$.

## Implementation Details
-   `LinkedList` in Java (Doubly Linked List) works as Deque.
