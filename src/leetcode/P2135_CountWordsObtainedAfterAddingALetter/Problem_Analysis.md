# Problem Analysis: Count Words Obtained After Adding a Letter

## Problem Description
`startWords`, `targetWords`.
Can convert startWord `s` to targetWord `t` if:
-   Add EXACTLY ONE letter to `s`.
-   Rearrange (sort) -> `t`.
Count `targetWords` that can be obtained from ANY `startWord`.

## Analysis

1.  **Bitmask / Sorting**:
    -   Since rearrange allowed, order doesn't matter. Represents set of chars.
    -   Bitmask (integer) for each word (26 bits).
    -   Values in `startWords`: store in `HashSet`.
    -   For each `t` in `targetWords`:
        -   Calculate mask `m_t`.
        -   Iterate each bit `b` present in `m_t`.
        -   Candidate start mask: `m_t ^ (1 << b)`.
        -   If candidate in set, `t` is obtainable. Break and count.

## Implementation Details
-   `Set<Integer> startMasks`.
-   Bit manipulation.
