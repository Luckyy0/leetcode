# Problem Analysis: Find Nearest Right Node in Binary Tree

## Problem Description
Given the `root` of a binary tree and a node `u` in the tree, return the **nearest** node on the **same level** that is to the **right** of `u`, or return `null` if `u` is the rightmost node in its level.

## Analysis

1.  **BFS (Level Order Traversal)**:
    -   Traverse the tree level by level.
    -   Use a `Queue`.
    -   Process one level at a time (track size of queue).
    -   Loop through nodes in current level.
    -   If current node is `u`:
        -   If it is the last node of this level (i.e., loop index == size - 1), return `null`.
        -   Otherwise, the next node in the queue is the answer. (Because queue stores level order).
        -   However, strictly speaking, "next node in queue" might be valid or might be mixed with next level children?
        -   If we process level by level cleanly (taking snapshot of size), the queue only contains elements of ONE level at start of processing loop.
        -   Actually, standard BFS pushes children to queue continuously.
        -   But if we iterate `sz = queue.size()` times, we are iterating exactly that specific level.
        -   So if we find `u` at index `i` (0 to `sz-1`), and `i < sz-1`, then `queue.peek()` is the one. (We just removed `u`, queue head is next).
        -   Wait, we `poll()` `u`. So next one is head.
    
2.  **Algorithm**:
    -   Queue init with root.
    -   While queue not empty:
        -   size = queue.size().
        -   Loop `i` from 0 to `size-1`:
            -   `cur = queue.poll()`.
            -   If `cur == u`:
                -   If `i < size - 1`: return `queue.peek()`.
                -   Else: return `null`.
            -   Push children.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ (Queue width).

## Implementation Details
-   `Queue<TreeNode>`.
