# Problem Analysis: Defuse the Bomb

## Problem Description
Circular array `code` of length `n`, key `k`.
-   If `k > 0`: replace `i`th number with sum of next `k` numbers.
-   If `k < 0`: replace `i`th number with sum of previous `k` numbers.
-   If `k == 0`: replace with 0.

## Analysis

1.  **Simulation**:
    -   Handle `k=0` directly (return new array of 0s).
    -   Use modulo `% n` for circular indexing.
    -   If `k > 0`: `sum(code[(i + j) % n])` for `j` in `1..k`.
    -   If `k < 0`: `sum(code[(i - j + n) % n])` for `j` in `1..|k|`.

2.  **Complexity**:
    -   Time: $O(N \cdot K)$. Since $N, K \le 100$, $10^4$ ops. Very fast.
    -   Space: $O(N)$.

## Implementation Details
-   `Math.abs(k)`.
-   Correct index handling. `(i + j) % n` for forward. `(i - j + n) % n` for backward.
