# Problem Analysis: Number of Ways to Reorder Array to Get Same BST

## Problem Description
Given an array `nums` that represents a permutation of integers from `1` to `n`. We are going to construct a binary search tree (BST) by inserting the elements of `nums` in order into an initially empty BST. Find the number of different ways to reorder `nums` such that the constructed BST is identical to that formed by the original `nums`.
Return the number of ways modulo $10^9 + 7$. One of the ways is the original `nums` itself.
Actually return `result - 1`.

## Analysis

1.  **BST Structure Property**:
    -   The first element of `nums` must be the root.
    -   All subsequent elements smaller than the root belong to the left subtree relative order.
    -   All subsequent elements larger than the root belong to the right subtree relative order.
    -   This structure is recursive.

2.  **Combination Logic**:
    -   Suppose the left subtree has $L$ nodes and the right subtree has $R$ nodes.
    -   The root is fixed at position 0.
    -   The remaining $L+R$ positions in the array must be filled with the $L$ left nodes and $R$ right nodes.
    -   The **internal relative order** of the $L$ nodes must be preserved (to form the same left subtree).
    -   The **internal relative order** of the $R$ nodes must be preserved (to form the same right subtree).
    -   However, the $L$ nodes and $R$ nodes can be interleaved in any way.
    -   Number of interleavings = $\binom{L+R}{L}$.
    -   Total ways for current tree = $\binom{L+R}{L} \times \text{ways}(Left) \times \text{ways}(Right)$.

3.  **Algorithm**:
    -   Function `count(subArray)`:
        -   If empty, return 1.
        -   `root = subArray[0]`.
        -   `leftArray = filter(< root)`, `rightArray = filter(> root)`.
        -   `combinations = nCr(leftArray.size() + rightArray.size(), leftArray.size())`.
        -   `return combinations * count(leftArray) * count(rightArray)`.
    -   Final answer is `count(nums) - 1` modulo arithmetic.

4.  **Constraint handling**:
    -   $N \le 1000$.
    -   Recursion depth $O(N)$.
    -   Need to precompute Pascal's triangle for combinations to avoid $O(N)$ calculation each time.

5.  **Complexity**:
    -   Time: $O(N^2)$ due to array splitting and filtering at each level (average case $N \log N$ for balanced, worst case $N^2$).
    -   Space: $O(N^2)$ for storage of combinations table.

## Implementation Details
-   Use `long` for calculations to prevent overflow before Modulo.
-   Precompute `C[i][j]` (Pascal triangle).
