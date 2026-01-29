# Problem Analysis: Build Binary Expression Tree From Infix Expression

## Problem Description
A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with 2 children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

For each internal node with operator `o`, the infix expression that it represents is `(A o B)`, where `A` is the expression the left subtree represents and `B` is the expression the right subtree represents.

Given a string `s`, an infix expression, return the root of the binary expression tree.
Operands are single digits.

## Analysis

1.  **Parsing Strategy**:
    -   Standard Two-Stack Algorithm for parsing expressions.
    -   `nodes` stack stores `TreeNode` objects.
    -   `ops` stack stores `Character` operators.
    -   Precedence: `*` = `/` (High), `+` = `-` (Low). Parentheses explicitly override.

2.  **Algorithm**:
    -   Iterate through string `s`.
    -   If digit: Create `new Node(val)`. Push to `nodes`.
    -   If '(': Push to `ops`.
    -   If ')':
        -   While `ops.peek() != '('`:
            -   Pop operator `op`. Pop `right`, `left`. Create `node(op, left, right)`. Push to `nodes`.
        -   Pop `(`.
    -   If Operator (`op`):
        -   While `!ops.isEmpty()` and `precedence(ops.peek()) >= precedence(op)`:
            -   (Note: `(` effectively has lowest precedence when on stack, or handle explicitly not to pop it).
            -   Wait, standard logic: `precedence('(')` is lowest, or explicitly check `peek() != '('`.
            -   Pop `oldOp`. Pop `right, left`. Create `node`. Push.
        -   Push `op` to `ops`.
    -   After string end: Pop remaining `ops` and build nodes.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   Helper `calculate(op, left, right)` unnecessary, just build tree.
-   `Node` definition assumed (val is char/int? Problem usually implies char for op, val for leaf. Wait, leaf is single digit. Return usually `Node` with char value?).
-   Standard LeetCode definition for `Node` usually has `char val`, `left`, `right`.
