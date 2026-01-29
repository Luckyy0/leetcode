# Problem Analysis: Kth Smallest Instructions

## Problem Description
Bob is at `(0, 0)` and wants to reach `(row, col)`. Usually represented as `m x n` grid where destination is `destination`.
Instructions: 'H' (horizontal) or 'V' (vertical).
Total 'H' steps needed: `col`.
Total 'V' steps needed: `row`.
Return the $k^{th}$ lexicographically smallest instruction string. 'H' < 'V'.

## Analysis

1.  **Combinatorics**:
    -   At any point, we have `h` horizontal steps left and `v` vertical steps left.
    -   We need to append either 'H' or 'V'.
    -   If we append 'H', how many total permutations start with 'H'?
    -   It is the number of ways to arrange `h-1` 'H's and `v` 'V's.
    -   `Count = Combinations(h - 1 + v, v)`.
    -   If $k \le Count$, then the $k^{th}$ string MUST start with 'H'.
        -   Append 'H'.
        -   Decrement `h`.
    -   If $k > Count$, then the $k^{th}$ string starts with 'V'.
        -   Append 'V'.
        -   Decrement `v`.
        -   `k -= Count` (we skip all the 'H'-starting strings).
    -   Repeat until $h=0$ and $v=0$.

2.  **Calculation**:
    -   Need `nCr`. Note that values can be large, but problem grid is small ($15 \times 15$). Max sum is 30.
    -   $30 C 15$ fits in standard integer? $30 C 15 \approx 1.5 \times 10^8$. Fits in `int`.
    -   Precompute combinatorics or compute on fly.

3.  **Complexity**:
    -   Time: $O(R+C)$.
    -   Space: $O(1)$ (or simple lookup).

## Implementation Details
-   Loop `h + v` steps.
-   Be careful with indices and k (1-indexed).
