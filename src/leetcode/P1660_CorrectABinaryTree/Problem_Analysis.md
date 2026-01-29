# Problem Analysis: Correct a Binary Tree

## Problem Description
You have a binary tree with a root node.
The tree is "defective": exactly one node has its **right child** incorrectly pointing to another node that is already in the tree.
More specifically, the invalid right child points to a node that would act as a parent or a right-peer (node at same level to the right) in terms of standard tree structure.
Usually described as: "The invalid node appears as a right child of some node `u`, but points to `v` where `v` is located to the right of `u` in the same level or an ancestor level."
Correct the tree by deleting the node `u` (that has the bad right pointer? No, the problem says 'delete the node and all its descendants' where the node is the one originating the bad pointer? Or the node being pointed to?).
Re-reading standard P1660 Problem Statement:
"A node `u` has `u.right = v`, and `v` is also in the tree."
"Constraint: The invalid edge points from a node to a node on the same level to its right."
Action: **Remove the node `u`** (and its descendants).

## Analysis

1.  **Algorithm**:
    -   We need to detect the condition "`v` is to the right of `u`".
    -   Standard BFS traverses level by level, usually Left to Right.
    -   If we traverse **Right to Left**, then for any level, we visit nodes on the right first.
    -   If `u` points to `v` (where `v` is to the right of `u`), then `v` will have been visited *before* `u` in our Right-to-Left BFS.
    -   So, for each node `u`, we check if `u.right` has been visited.
    -   If `u.right` is in visited set, then `u` is the invalid node.
    -   We need to remove `u`.
    -   Since we need to remove `u` from its parent, we need parent reference or handle children.
    -   Actually, simpler: BFS Queue stores `(node)`.
    -   When expanding `node`, check `node.right`.
    -   If `node.right` visited, then `node` is invalid. We can't delete `node` directly without parent.
    -   However, the problem usually asks to return Root.
    -   Maybe we pass the parent?
    -   Better: Store `(node, parent)` in queue? Or just inspect children.
    -   If `node.right.right` is visited? No.
    -   Correct check: For current node `curr` in BFS:
        -   If `curr.right` exists and `visited` contains `curr.right`:
            -   This means `curr` is the invalid node.
            -   But wait, if `curr` is invalid, we must remove it from `parent`.
            -   So we need to check this *before* putting `curr` in queue?
            -   Or when expanding parent:
            -   For parent `p`:
                -   Right child `r = p.right`.
                -   Left child `l = p.left`.
                -   Process `r` first (add to visited). Push `r`.
                -   Process `l`.
                -   This way `r` is visited.
                -   If `l` has a bad pointer to `r` (or something rightwards), `l.right` will be in visited.
                -   So when expanding `l`, we check `if visited.contains(l.right)`.
                -   If so, `l` is bad (but wait, `l` is child of `p`).
                -   If `l` is bad, `p.left = null`.
            -   Let's refine:
                -   BFS `Right -> Left`.
                -   Queue stores `TreeNode`.
                -   Set `visited` stores `TreeNode`.
                -   While queue not empty:
                    -   `curr = poll`.
                    -   If `curr.right != null`:
                        -   If `visited.contains(curr.right)`:
                            -   Wait, if `curr.right` is visited, it means `curr` points to a visited node.
                            -   So `curr` is the node to delete.
                            -   To delete `curr`, we need to validly return disjoint tree.
                            -   Actually, better to solve with pure method:
                            -   `correctBinaryTree(root)`:
                                -   BFS logic. But modify tree.
                                -   Queue `(node, parent)`.
                                -   If `node.right` in visited: `parent.link = null`.
                                -   Note: `parent.link` could be left or right. Check which one `node` is.

2.  **Implementation**:
    -   Queue `TreeNode`. `HashMap<TreeNode, TreeNode>` parent map? Or `Queue<Pair>`.
    -   `visited`.
    -   Add `root` to queue, `visited`.
    -   Loop:
        -   Poll `(node, parent)`.
        -   If `node.right != null` and `visited.contains(node.right)`:
            -   This `node` is invalid.
            -   Remove `node` from `parent`.
            -   If `parent.left == node` -> `parent.left = null`.
            -   Else `parent.right = null`.
            -   Return `root`.
        -   Push children Right then Left.
        -   `visited.add(child)`.

## Implementation Details
-   `Queue` stores `node`.
-   Actually, simpler: Since we traverse right-to-left, checking `node.right` existence in visited is the condition.
-   Just need to know `parent` to delete.

