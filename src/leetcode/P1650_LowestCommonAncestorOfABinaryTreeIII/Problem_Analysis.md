# Problem Analysis: Lowest Common Ancestor of a Binary Tree III

## Problem Description
Given two nodes of a binary tree `p` and `q`, return their Lowest Common Ancestor (LCA).
Each node has a reference to its parent. The root of the tree is not explicitly given (can be found via parents).

## Analysis

1.  **Structure**:
    -   Since we have parent pointers, this problem acts exactly like "Intersection of Two Linked Lists".
    -   The path from `p` to root and `q` to root are two linked lists merging at the LCA.
    
2.  **Algorithm**:
    -   Pointer `a` starting at `p`, `b` starting at `q`.
    -   Move `a` up. When `a` reaches null (past root), jump to `q`.
    -   Move `b` up. When `b` reaches null (past root), jump to `p`.
    -   They will meet at the intersection (LCA) after at most 2 traversals of the combined height.
    -   Why? Let path `p->LCA` be length `L1`, `q->LCA` be `L2`, `LCA->Root` be `C`.
    -   Path A: `L1 + C + L2`.
    -   Path B: `L2 + C + L1`.
    -   Wait, the logic is: Distance `p` to root is $d_p$, `q` to root is $d_q$.
    -   Distance to LCA is $l$. Root is common.
    -   Actually standard intersection logic works perfectly.
    -   If `a` reaches root (parent null), set `a = q`.
    -   If `b` reaches root (parent null), set `b = p`.
    -   Loop until `a == b`.

3.  ** Complexity**:
    -   Time: $O(H)$.
    -   Space: $O(1)$.

## Implementation Details
-   `Node` definition includes `parent`.
