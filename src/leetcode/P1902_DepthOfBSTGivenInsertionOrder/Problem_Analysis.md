# Problem Analysis: Depth of BST Given Insertion Order

## Problem Description
Insertion `order`. Build BST. Return max depth.
Constraint: `N <= 10^5`. Simple BST insertion is $O(N^2)$ worst case. Time limit will exceed.

## Analysis

1.  **Values and Intervals (Treemap)**:
    -   When inserting val `x`, it becomes a child of some node already in the tree.
    -   In BST, a new node `x` will be a child of:
        -   The value just smaller than `x` (predecessor).
        -   OR The value just larger than `x` (successor).
        -   Specifically, one of them will be the leaf where `x` falls.
        -   The one with the **greater** depth will be the parent.
    -   Logic:
        -   The "range" `(pred, succ)` covers the spot where `x` is inserted.
        -   `pred` and `succ` are the current bounds in the BST structure.
        -   One of them must be the direct parent.
        -   Since `x` is inserted "later" than `pred` and `succ`, and falls between them, it must be the child of whichever is deeper.
    -   Use `TreeMap<Integer, Integer>` storing `val -> depth`.
    -   For each `x`:
        -   `lower = map.lowerKey(x)`. `depthL = lower ? map.get(lower) : 0`.
        -   `higher = map.higherKey(x)`. `depthH = higher ? map.get(higher) : 0`.
        -   `depthX = 1 + max(depthL, depthH)`.
        -   `map.put(x, depthX)`.
        -   Update `maxDepth`.
    -   Complexity: $O(N \log N)$. This works.

## Implementation Details
-   `TreeMap`.
