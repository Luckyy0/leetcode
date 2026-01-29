# Problem Analysis: Number Of Ways To Reconstruct A Tree

## Problem Description
`pairs` is list of ancestors/descendants.
Return 0, 1, or 2 (infinite/multiple).

## Analysis

1.  **Structure Rules**:
    -   If `u` is parent of `v`, then `adj(u)` must contain `adj(v)`. (Parent is ancestor of all of child's descendants).
    -   Degree Check: Root must have degree `n-1`.
    -   Construct tree by assigning parent.
    -   Sort nodes by degree (descending). `root` has max degree.
    -   For each node `u`, candidate parent `p` is the neighbor with smallest degree > `degree(u)`. (Closest ancestor).
    -   Verify `adj(u)` subset `adj(p)`.
    -   If verification fails, return 0.
    -   If `degree(u) == degree(p)`, we can swap them -> multiple ways (return 2).
    -   If structure holds for all, return 1 (unless 2 triggered).

2.  **Algorithm**:
    -   Build adjacency map.
    -   Check if root exists (`deg == n-1`). Else 0.
    -   Sort.
    -   Iterate nodes. Find parent. Check subset.
    -   Multiple flag.

3.  **Complexity**:
    -   Time: $O(N^2)$ or $O(M)$ (pairs).
    -   `N <= 500`.

## Implementation Details
-   `Set<Integer>[] adj`.
-   BitSet or HashSet usage.
