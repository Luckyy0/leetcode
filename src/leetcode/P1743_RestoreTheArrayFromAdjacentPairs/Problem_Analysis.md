# Problem Analysis: Restore the Array From Adjacent Pairs

## Problem Description
`adjacentPairs` given. Original array had `n` unique elements.
Reconstruct.

## Analysis

1.  **Graph/List**:
    -   Build adjacency map.
    -   Start and End nodes have degree 1. Middle nodes have degree 2.
    -   Find a node with degree 1 (Start).
    -   Traverse (DFS/BFS) to construct array. Keep track of `prev` to avoid going back.

2.  **Algorithm**:
    -   Map `Integer -> List<Integer>`.
    -   Find start.
    -   Loop `n` times. Add logical neighbor.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   HashMap.
