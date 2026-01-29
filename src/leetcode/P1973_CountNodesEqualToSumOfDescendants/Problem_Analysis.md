# Problem Analysis: Count Nodes Equal to Sum of Descendants

## Problem Description
Binary Tree. Count nodes where `node.val == sum(descendants)`.
Descendants sum excludes the node itself.

## Analysis

1.  **Post-Order Traversal**:
    -   Return sum of subtree.
    -   `subtreeSum(node) = node.val + subtreeSum(left) + subtreeSum(right)`.
    -   `descendantSum = sum(left) + sum(right)`.
    -   If `node.val == descendantSum`, count++.
    -   Need to use `long` for sum to avoid overflow.

## Implementation Details
-   Recursive DFS.
