# Problem Analysis: Tree of Coprimes

## Problem Description
Tree with values `nums[i]`. `root=0`.
For each node `i`, find ancestor `j` such that `gcd(nums[i], nums[j]) == 1` and `j` is closest to `i` (max depth).
If multiple, node with largest ID? Actually "closest ancestor". So max depth.
If tie in depth? (Impossible in tree, each depth unique on path).

## Analysis

1.  **DFS with Ancestor Tracking**:
    -   `nums` values $\le 50$.
    -   We need to track the most recent ancestor for each value `1..50`.
    -   Store `ancestors[val]`: `(node_id, depth)`.
    -   Since values are small, we can keep an array/stack for each value `1..50` during DFS.
    -   When visiting node `u` with value `x`:
        -   Inspect all `v` in `1..50`. If `gcd(x, v) == 1`:
            -   Check stored ancestor for value `v`.
            -   Pick the one with max depth.
        -   Result for `u` is found.
    -   Push `u` to `ancestors[x]`.
    -   Recurse.
    -   Pop `u` after recursion (backtrack).
    
2.  **Complexity**:
    -   Time: $O(N \cdot 50)$. Each node checks 50 values.
    -   Space: $O(N + 50)$.

## Implementation Details
-   Precompute GCD pairs for 1..50? Or compute on fly.
-   `pos[val]` stores `(depth, id)`. Since it's DFS, we only need the *latest* entry. But wait, DFS path.
-   Yes, we just need the top of the stack for each value. Or just store depth and overwrite?
-   Actually, simpler: `pos[val]` holds stack of nodes with that value on current path. We look at `pos[v].peek()` for all copious `v`.

## Implementation Details
-   `coprimes[i]` list for each `i` up to 50.
