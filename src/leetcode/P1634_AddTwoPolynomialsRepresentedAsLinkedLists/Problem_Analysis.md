# Problem Analysis: Add Two Polynomials Represented as Linked Lists

## Problem Description
A polynomial linked list is a special type of linked list where every node represents a term of a polynomial.
Each node has `coefficient` and `power`. The polynomial is sorted by power in descending order.
Given two polynomial linked lists `poly1` and `poly2`, add them together and return the head of the sum.
The result must also be sorted by power descending. Coefficients with 0 should be omitted.

## Analysis

1.  **Merge Concept**:
    -   Since both lists are sorted by power descending, we can use the "Merge sorted lists" logic.
    -   Pointers `p1` and `p2`.
    -   Compare `p1.power` and `p2.power`.
    -   If equal: `sum = p1.coef + p2.coef`. If `sum != 0`, create node. Advance both.
    -   If `p1.power > p2.power`: Add `p1` term. Advance `p1`.
    -   If `p1.power < p2.power`: Add `p2` term. Advance `p2`.
    -   Handle remaining nodes.

2.  **Complexity**:
    -   Time: $O(N + M)$.
    -   Space: $O(1)$ (new nodes only for result, logic is in-place or new nodes, usually create new nodes).

## Implementation Details
-   `PolyNode` definition (given by problem).
-   Dummy head for result.
