# Problem Analysis: Even Odd Tree

## Problem Description
A binary tree is named **Even-Odd** if it meets the following conditions:
-   The root of the binary tree is at level index 0, its children are at level index 1, etc.
-   For every **even-indexed** level, all nodes at the level have **odd** integer values in **strictly increasing** order (from left to right).
-   For every **odd-indexed** level, all nodes at the level have **even** integer values in **strictly decreasing** order (from left to right).

Return `true` if the binary tree is Even-Odd, otherwise return `false`.

## Analysis

1.  **Traversal**:
    -   BFS (Level Order) is best suited to check level-by-level properties.

2.  **Validation**:
    -   Maintain `level` index.
    -   For each level, iterate nodes from left to right.
    -   Track `prevVal` to check monotonicity.
    -   If `level % 2 == 0` (Even Level):
        -   Values must be Odd (`val % 2 != 0`).
        -   Values must be Strictly Increasing (`val > prevVal`).
    -   If `level % 2 != 0` (Odd Level):
        -   Values must be Even (`val % 2 == 0`).
        -   Values must be Strictly Decreasing (`val < prevVal`).

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ (Queue).

## Implementation Details
-   `Queue<TreeNode>`.
-   Reset `prevVal` appropriately at start of each level (MIN_VALUE for increasing, MAX_VALUE for decreasing).
