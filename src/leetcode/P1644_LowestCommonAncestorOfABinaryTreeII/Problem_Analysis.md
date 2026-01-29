# Problem Analysis: Lowest Common Ancestor of a Binary Tree II

## Problem Description
Given root, `p`, `q`. Finds LCA. Return `null` if either `p` or `q` is not in the tree.

## Analysis

1.  **Requirement**:
    -   Must confirm existence of both `p` and `q`.
    -   Standard LCA algorithm assumes they exist. If `p` is root of `q`, it returns `p` immediately and doesn't verify `q`.
    -   We need to traverse the full tree (or at least enough to find both).

2.  **Approach**:
    -   Use a helper function that returns a count of matched nodes (0, 1, 2) and potentially sets a global `lca` variable.
    -   Actually, simpler: `dfs(root)` returns 0, 1, or 2 (number of targets found in subtree).
    -   If `root` is `p` or `q`, it contributes 1.
    -   `left = dfs(root.left)`, `right = dfs(root.right)`.
    -   `total = left + right + (root == p ? 1 : 0) + (root == q ? 1 : 0)`.
    -   If `total == 2` and `lca` is still null, then `root` is the LCA (because we are processing post-order, bottom-up).
    -   Wait, post-order guarantees we find the lowest one first?
    -   Yes. If `left` has 2, LCA was already found in left. If `total == 2` and neither child had 2 (meaning `left` < 2 and `right` < 2), this is the merge point or the root of the other.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(H)$.

## Implementation Details
-   Global `TreeNode ans = null`.
-   Return boolean or int in DFS.
