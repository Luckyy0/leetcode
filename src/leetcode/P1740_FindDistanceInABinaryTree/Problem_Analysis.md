# Problem Analysis: Find Distance in a Binary Tree

## Problem Description
Root of binary tree, two integer values `p` and `q`.
Return distance between nodes `p` and `q`.
Nodes are unique.

## Analysis

1.  **LCA Approach**:
    -   Find LCA of `p` and `q`.
    -   Distance = `dist(root, p) + dist(root, q) - 2 * dist(root, LCA)`.
    -   Or `dist(LCA, p) + dist(LCA, q)`.
    
2.  **Algorithm**:
    -   Single traversal to find LCA and depths?
    -   Actually standard recursive LCA function returns LCA node.
    -   Then BFS/DFS from LCA to find `p` and `q` and measure distance.
    -   Or: `findDistance(root, p)`. `findDistance(root, q)`.
    -   Wait, optimizing:
        -   Function `int dist(root, target)`. Returns distance from root to target, or -1.
        -   First Find LCA.
        -   Then `dist(LCA, p) + dist(LCA, q)`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(H)$.

## Implementation Details
-   `lowestCommonAncestor`.
-   `getDepth`.
