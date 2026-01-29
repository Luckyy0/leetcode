# Problem Analysis: Number of Wonderful Substrings

## Problem Description
String `word` ('a' to 'j').
Wonderful = at most one char appears odd times.
Count wonderful substrings.

## Analysis

1.  **Bitmask Prefix XOR**:
    -   Mask of 10 bits.
    -   Prefix mask at `i`: `P[i]`.
    -   Substring `(j, i]` mask is `P[i] ^ P[j]`.
    -   Condition: `diff = P[i] ^ P[j]` has 0 or 1 bits set.
    -   `count[mask]` stores frequency of masks seen so far.
    -   Iterate `i` from 0 to `n`:
        -   Current mask `curr`.
        -   Add `count[curr]` to result (0 bit diff).
        -   For `k` in 0..9: Add `count[curr ^ (1<<k)]` (1 bit diff).
        -   Increment `count[curr]`.

## Implementation Details
-   `long` result.
-   Array `count` size 1024.
