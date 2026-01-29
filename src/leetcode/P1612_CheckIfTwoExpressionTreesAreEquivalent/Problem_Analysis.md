# Problem Analysis: Check If Two Expression Trees are Equivalent

## Problem Description
A binary expression tree is a kind of binary tree used to represent arithmetic expressions.
The leaves of an expression tree are variables 'a'-'z'. The internal nodes are operators, here only '+'.
Two expression trees are equivalent if their values are equal for any instantiation of variables.
Return `true` if the two binary expression trees are equivalent. Otherwise, return `false`.

## Analysis

1.  **Properties**:
    -   The only operator is `+` (Addition).
    -   Addition is Commutative (`a+b = b+a`) and Associative (`(a+b)+c = a+(b+c)`).
    -   Therefore, the structure of the tree doesn't matter, only the set of leaf variables matters.
    -   Specifically, the count of each variable must be identical in both trees.

2.  **Algorithm**:
    -   Traverse `root1` and count frequency of each char 'a'-'z'.
    -   Traverse `root2` and count frequency.
    -   Compare the frequency arrays.

3.  **Complexity**:
    -   Time: $O(N + M)$ nodes.
    -   Space: $O(1)$ (frequency array size 26).

## Implementation Details
-   DFS traversal.
-   Node class definition assumed (val is char, left, right).
