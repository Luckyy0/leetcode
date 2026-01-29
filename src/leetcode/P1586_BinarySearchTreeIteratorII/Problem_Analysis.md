# Problem Analysis: Binary Search Tree Iterator II

## Problem Description
Implement the `BSTIterator` class that represents an iterator over the in-order traversal of a binary search tree (BST):
-   `BSTIterator(TreeNode root)` Initializes the object with the `root` node of the BST.
-   `boolean hasNext()` Returns `true` if there exists a number in the traversal to the right of the pointer, otherwise returns `false`.
-   `int next()` Moves the pointer to the right, then returns the number at the pointer.
-   `boolean hasPrev()` Returns `true` if there exists a number in the traversal to the left of the pointer, otherwise returns `false`.
-   `int prev()` Moves the pointer to the left, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number, the first call to `next()` will return the smallest element in the BST.

## Analysis

1.  **Requirements**:
    -   Standard Iterator functionality (`next`, `hasNext`) plus backwards traversal (`prev`, `hasPrev`).
    -   Standard BST Iterator uses a Stack to achieve $O(h)$ space and amortized $O(1)$ time.
    -   Backwards traversal suggests we need to remember the sequence we provided.

2.  **Approach**:
    -   Use a standard (Stack-based) iterator approach to discover nodes in In-Order.
    -   Store all visited nodes (or their values) in a `List` (History).
    -   Maintain an internal index `pointer` which tracks the current position in the `List`.
    -   Initialized `pointer = -1`.

3.  **Operations**:
    -   `hasNext()`:
        -   True if `pointer < list.size() - 1` (we can move forward in history).
        -   OR if the Stack is not empty (we can discover new nodes).
    -   `next()`:
        -   increment `pointer`.
        -   if `pointer == list.size()`:
            -   We need to discover the next node from Stack.
            -   Pop stack, push right child's left spine.
            -   Add value to `list`.
        -   Return `list.get(pointer)`.
    -   `hasPrev()`:
        -   True if `pointer > 0`.
    -   `prev()`:
        -   decrement `pointer`.
        -   Return `list.get(pointer)`.

4.  **Complexity**:
    -   Time: Amortized $O(1)$ for all ops. Each node processed once by stack logic. List access is $O(1)$.
    -   Space: $O(N)$ to store the list of values.

## Implementation Details
-   Standard iterative In-Order with Stack logic.
-   `pushLeft(node)` helper.
