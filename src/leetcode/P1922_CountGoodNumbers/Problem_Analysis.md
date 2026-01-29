# Problem Analysis: Count Good Numbers

## Problem Description
Length `n`. Good if:
Even indices (0, 2...) are even digits (0, 2, 4, 6, 8) -> 5 options.
Odd indices (1, 3...) are prime digits (2, 3, 5, 7) -> 4 options.
Count good numbers mod $10^9 + 7$.

## Analysis

1.  **Math**:
    -   Count even pos: `(n + 1) / 2`. (Indices 0, 2... for length n).
    -   Count odd pos: `n / 2`.
    -   Ans = $5^{even} \times 4^{odd} \pmod P$.
    -   Use modular exponentiation.

## Implementation Details
-   `power` function.
