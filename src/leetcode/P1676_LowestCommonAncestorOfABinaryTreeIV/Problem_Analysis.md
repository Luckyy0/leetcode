# Problem Analysis: Lowest Common Ancestor of a Binary Tree IV

## Problem Description
Given the `root` of a binary tree and an array of `TreeNode` objects `nodes`, return the lowest common ancestor (LCA) of all the nodes in `nodes`.
All the nodes will exist in the tree, and all values of the tree's nodes are unique.

## Analysis

1.  **Recursive LCA**:
    -   The logic extends naturally from LCA of two nodes.
    -   If `root` matches ANY node in the target set `nodes`, then `root` is an ancestor (possibly the LCA itself, or an ancestor of the LCA if LCA is `root`). Since we are in the subtree rooted at `root`, and `root` is a target, any other targets must be in subtrees, making `root` the LCA for this subset.
    -   Wait, standard logic: If `root` is one of the nodes, it effectively "captures" the requirement for that node. Does it capture others? 
        -   If `LCA` is `root`, then `root` must be an ancestor of ALL nodes. 
        -   If `root` is in the set, and we are looking for LCA of `root` and others, `root` is the LCA.
        -   So: `if (set.contains(root)) return root;`.
    -   Recurse: `left = lca(root.left)`, `right = lca(root.right)`.
    -   If both `left` and `right` differ from null: `root` is the split point (LCA).
    -   If only one is not null: return that one.
    -   If both null: return null.
    
2.  **Optimized Lookup**:
    -   Store `nodes` in a `HashSet` for $O(1)$ lookup.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(H)$ recursion + $O(K)$ set.

## Implementation Details
-   HashSet of TreeNodes.
