# Problem Analysis: Number of Sets of K Non-Overlapping Line Segments

## Problem Description
Given `n` points labeled `0` to `n-1` on a 1D plane.
Find the number of ways to draw `k` non-overlapping line segments. Segments are allowed to share endpoints.
Return modulo $10^9 + 7$.

## Analysis

1.  **Combinatorial Interpretation**:
    -   We have `n` points, which translates to `n-1` unit intervals.
    -   We need to select `k` segments. Each segment is a sequence of contiguous unit intervals.
    -   Equivalent problem: Distribute `k` segments and `n-1 - L` empty spaces? (L is total length).
    -   Alternative formulation:
        -   We need to choose `2k` endpoints from the `n` points. However, picking endpoints directly is tricky because segments can share points (e.g. end of one is start of next).
        -   Let's map this to a simpler selection problem using "stars and bars".
        -   Consider the configuration as a sequence of choices as we traverse from 0 to n-1.
        -   We choose $k$ segments. Each segment needs a start point and an end point.
        -   This is equivalent to choosing `2k` items from a set of size `n + k - 1`.
        -   Formula: $\binom{n + k - 1}{2k}$.
    -   Let's verify logic:
        -   Imagine we place `n-1` points in a row representing the atomic intervals.
        -   We want to place `k` segments.
        -   This problem is isomorphic to: Construct a sequence of length `n-1` using `k` 'Segment' blocks and `n-1 - Sum(Lengths)` 'Gap' blocks?
        -   No, segments share endpoints.
        -   Let's use the explicit bijection:
            -   Map each choice of $k$ segments to a choice of $2k$ items from $n - 1 + k$ items.
            -   Suppose we choose indices $y_1, y_2, \dots, y_{2k}$ from $\{0, \dots, n + k - 2\}$.
            -   This maps back to segments.
    -   The formula $\binom{n + k - 1}{2k}$ is standard for this specific problem ("Number of ways to choose k non-overlapping intervals from n points with shared endpoints allowed").

2.  **Algorithm**:
    -   Compute Combinations $C(N, R) \pmod P$.
    -   $C(N, R) = \frac{N!}{R!(N-R)!} \pmod P$.
    -   We need modular inverse for division.
    -   Or simply calculate product `(N)(N-1)...(N-R+1) / R!`.
    -   Here $N = n + k - 1$, $R = 2k$.

3.  **Complexity**:
    -   Time: $O(K)$ or $O(K \log MOD)$ for inverse.
    -   Space: $O(1)$.

## Implementation Details
-   `BigInteger` for intermediate product or manual loop with modular inverse.
-   Modulo `1_000_000_007`.
