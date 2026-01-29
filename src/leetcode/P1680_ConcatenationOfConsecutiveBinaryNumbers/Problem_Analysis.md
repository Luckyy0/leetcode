# Problem Analysis: Concatenation of Consecutive Binary Numbers

## Problem Description
Given integer `n`, return the decimal value of the binary string formed by concatenating the binary representations of `1` to `n` in order, modulo $10^9 + 7$.

## Analysis

1.  **Simulation**:
    -   Start `res = 0`.
    -   Iterate `i` from 1 to `n`.
    -   Shift `res` to the left by the number of bits in `i`.
    -   Add `i`.
    -   Modulo at each step.
    
2.  **Bit Length**:
    -   Length of binary `i` is `floor(log2(i)) + 1` or `Integer.toBinaryString(i).length()`.
    -   Optimized: The bit length increases only when `i` is a power of 2.
    -   Track current length `len`. If `i` is power of 2 (i & (i-1) == 0), `len++`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   `long res`.
-   MOD = `1_000_000_007`.
