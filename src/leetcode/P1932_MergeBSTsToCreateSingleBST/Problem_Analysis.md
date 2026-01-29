# Problem Analysis: Merge BSTs to Create Single BST

## Problem Description
List of `trees` (roots).
Merge all trees into one BST.
Leaves can be replaced by roots of other trees if values match.
Result must be a VALID BST containing ALL nodes from input trees.
Return root or null.

## Analysis

1.  **Graph/Tree Construction**:
    -   Each tree in input is a component.
    -   Merge operation: `Leaf U` matches `Root V`.
    -   This is a directed edge $U \to V$ conceptually (we hang $V$ at $U$).
    -   Or rather, since we must use ALL trees, we look for roots that can fit into leaves.
    -   Count occurrences of each value in roots vs leaves.
    -   Roots: Stores `val -> TreeNode`. Map `rootVal -> Node`.
    -   Leaves: Traverese all trees. Identify leaves.
    -   Actually, identify the unique root of the final tree.
        -   A value `v` that is a Root of some input tree but NOT a leaf/child in any other input tree must be the global root.
        -   If multiple such roots -> Impossible (Disconnected).
        -   If zero -> Cycle.
    -   Algorithm:
        -   Map `roots`: value -> TreeNode.
        -   Map `parents`: value -> count (how many times this value appears as a child in input trees).
        -   Populate `roots` map.
        -   Populate `parents` counts by traversing all input trees (just direct children).
        -   Find candidate root: A `roots` entry whose value has count 0 in `parents`.
        -   Should be exactly one. If not, return null.
        -   Start building from candidate root.
        -   While traversing, if we hit a leaf and its value exists in `roots`, replace leaf with that root and continue traversing.
        -   Remove consumed roots from set.
        -   Check:
            1.  BST property valid? (Range check).
            2.  All input roots used? (Count nodes or keep track of visited roots).
            3.  Total nodes count. Note duplicates? Values are unique across all nodes in final BST. If input has duplicate values (e.g. two trees have node 5 as child), impossible. (BST unique values).

2.  **Validation**:
    -   Global inorder traversal to check strict increasing.
    -   Or range validation during DFS `(min, max)`.

## Implementation Details
-   `Map<Integer, TreeNode> rootMap`.
-   `Set<Integer> childrenVals`.
-   Traverse to check validity.
