# Problem Analysis: Create Binary Tree From Descriptions

## Problem Description
`descriptions[i] = [parent, child, isLeft]`.
Unique values.
Construct tree. Return root.

## Analysis

1.  **HashMap**:
    -   `Map<Integer, TreeNode> nodes`.
    -   `Set<Integer> children` to track who is a child.
    -   Iterate descriptions:
        -   Get/Create parent node.
        -   Get/Create child node.
        -   Link.
        -   Add child val to set.
    -   Find root: Iterate `nodes.keySet()`, find the one not in `children`.

## Implementation Details
-   Map logic.
-   `getOrDefault`.
