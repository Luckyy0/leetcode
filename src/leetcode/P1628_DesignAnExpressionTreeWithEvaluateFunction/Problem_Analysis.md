# Problem Analysis: Design an Expression Tree With Evaluate Function

## Problem Description
Design an expression tree for an arithmetic expression. The tree can contain operators `+`, `-`, `*`, `/` and numeric values.
Implement the class `Node` and `TreeBuilder`.
`Node` must have an abstract method `evaluate()`.
`TreeBuilder` has `buildTree(String[] postfix)` which returns the root.

## Analysis

1.  **Class Structure**:
    -   Abstract class `Node` with `evaluate`.
    -   Concrete implementation `TreeNode` (or `NumNode` and `OpNode`).
    -   `NumNode` stores value. Returns value.
    -   `OpNode` stores `left`, `right`, `op`. Returns `evaluate(left) op evaluate(right)`.

2.  **Tree Building**:
    -   Input is Postfix.
    -   Use a Stack.
    -   Iterate tokens.
    -   If number: Push `new NumNode(val)`.
    -   If operator: Pop `right`, Pop `left`. Push `new OpNode(op, left, right)`.
    -   Return stack peek.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   Inner classes for Node implementations.
