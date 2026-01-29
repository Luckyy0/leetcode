# Problem Analysis: Tuple with Same Product

## Problem Description
Distinct integers `nums`. Count tuples `(a, b, c, d)` from `nums`: `a * b = c * d`.
Elements must be distinct in tuple? `(a, b)` distinct from `(c, d)`.
But `a != b` since `nums` distinct.
Order matters.

## Analysis

1.  **Pair Products**:
    -   Iterate all pairs `(i, j)` with `i < j`. Product `P = nums[i] * nums[j]`.
    -   Store in map `product -> count`.
    -   If `count` pairs have product `P`, we can choose 2 pairs in `C(count, 2)` ways.
    -   Let's say pairs are `{a, b}` and `{c, d}`.
    -   Valid tuples:
        -   `(a, b, c, d)`
        -   `(a, b, d, c)`
        -   `(b, a, c, d)`
        -   `(b, a, d, c)`
        -   `(c, d, a, b)`
        -   `(c, d, b, a)`
        -   `(d, c, a, b)`
        -   `(d, c, b, a)`
    -   Total 8 permutaions for each combination of 2 pairs.
    -   Total = `8 * count * (count - 1) / 2` = `4 * count * (count - 1)`.

2.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N^2)$.

## Implementation Details
-   `HashMap<Integer, Integer>`.
