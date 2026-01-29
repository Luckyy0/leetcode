# Problem Analysis: Incremental Memory Leak

## Problem Description
`memory1`, `memory2`.
Time `i=1, 2, ...`.
At second `i`, subtract `i` from stick with MORE memory (max). Or overlap?
"Subtract i bits from the memory stick with the more available memory."
If equal, stick 1.
Stop if `i > both`.

## Analysis

1.  **Simulation**:
    -   While `m1 >= i` or `m2 >= i`:
    -   Logic to pick stick.
    -   Update. `i++`.
    -   Result `[i, m1, m2]`.

2.  **Complexity**:
    -   Memory decreases by `i`. Total memory roughly $M$. steps $\approx \sqrt{2M}$.
    -   Max $M=2^{31}-1$. $\sqrt{M} \approx 46340$.
    -   Simulation is fast enough.

## Implementation Details
-   Loop.
