# Problem Analysis: Change the Root of a Binary Tree

## Problem Description
Given the root of a binary tree and a leaf node, reroot the tree so that the leaf is the new root.
The binary tree has parent pointers.
You need to change the parent pointers along the path from leaf to root, and adjust child pointers accordingly.
Specifically:
-   If `node` becomes the parent of `old_parent`:
    -   `old_parent`'s pointer to `node` (left or right) must be cleared.
    -   `node` must now point to `old_parent` as a child (left or right).
    -   If `node.left` is occupied, use `node.right`. If `node` was a leaf, `left` is free.
-   Return the new root.

## Analysis

1.  **Recursive Approach**:
    -   Function `flip(node, newParent)`:
        -   Base case: If `node` is null, return.
        -   Save `oldParent = node.parent`.
        -   Set `node.parent = newParent`.
        -   Recurse: `flip(oldParent, node)`.
        -   Attach `oldParent` to `node`:
            -   If `oldParent` is not null:
                -   First, detach `node` from `oldParent` (to free up child slot on oldParent side).
                    -   If `oldParent.left == node`, `oldParent.left = null`.
                    -   Else `oldParent.right = null`.
                -   Then, attach `oldParent` to `node` (as child).
                    -   If `node.left == null`, `node.left = oldParent`.
                    -   Else `node.right = oldParent`.
    -   Start with `flip(leaf, null)`.

2.  **Refinement**:
    -   Ordering is crucial.
    -   We must fix the parent pointers upwards.
    -   The recursion effectively walks up the tree.
    -   Wait, standard reversal:
        -   Leaf becomes root.
        -   Leaf's parent becomes Leaf's child.
        -   Parent's parent becomes Parent's child.
        -   etc.
    -   Recursion makes sense.
    -   Call `flip(leaf)`. Inside `flip(curr)`:
        -   `prev = curr.parent`.
        -   If `prev != null`:
            -   `flip(prev)`.
            -   Detach `curr` from `prev`.
            -   Attach `prev` to `curr`.
            -   Update `prev.parent` to `curr`.
        -   `curr.parent` will be null if it's the new root (leaf).
        -   Wait, the recursion logic above `flip(leaf, null)` sets `leaf.parent = null`.
        -   Then recurse `flip(originalParent, leaf)`.
        -   Inside that, `originalParent.parent` set to `leaf`.
        -   Detach from old child `leaf`.
        -   Attach `leaf` as parent? No, attach `originalParent` to `leaf` as child.
        -   Wait, we need to modify `leaf.left` or `leaf.right`.
        -   This needs to be done carefully.

3.  **Correct Logic**:
    -   `flip(node, newParent)`:
        -   `oldParent = node.parent`.
        -   `node.parent = newParent`.
        -   If `node.left == newParent`, `node.left = null`.
        -   If `node.right == newParent`, `node.right = null`.
        -   If `oldParent != null`:
            -   `flip(oldParent, node)`.
            -   If `node.left != null`, `node.right = oldParent`.
            -   Else `node.left = oldParent`.

4.  **Complexity**:
    -   Time: $O(H)$ (path length).
    -   Space: $O(H)$.

## Implementation Details
-   Node class with parent.
