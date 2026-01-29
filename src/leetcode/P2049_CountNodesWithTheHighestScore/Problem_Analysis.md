# Problem Analysis: Count Nodes With the Highest Score

## Problem Description
Tree `parents` array.
Score of a node = Product of sizes of components formed by removing the node.
Find count of nodes with max score.
Components:
-   Subtrees of children.
-   The rest of the tree (Parent side).
    -   Size = `TotalNodes - 1 - Size(Children)`.

## Analysis

1.  **DFS and Size Calculation**:
    -   Compute size of subtree at each node.
    -   For node `u`:
        -   Children sizes `s1, s2...`
        -   Rest size `R = N - 1 - sum(si)`.
        -   Score `u` = `prod(si) * R` (if $R > 0$).
        -   Use `long` for score.
    -   Track max score and count.

## Implementation Details
-   `Adjacency list`.
-   `DFS`.
